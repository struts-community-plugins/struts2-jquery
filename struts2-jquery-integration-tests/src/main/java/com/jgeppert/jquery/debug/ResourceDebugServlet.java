// Create this file: struts2-jquery-integration-tests/src/main/java/com/jgeppert/jquery/debug/ResourceDebugServlet.java

package com.jgeppert.jquery.debug;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/debug/resources/*")
public class ResourceDebugServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();

        String pathInfo = req.getPathInfo();
        out.println("=== Resource Debug Information ===");
        out.println("Request URI: " + req.getRequestURI());
        out.println("Path Info: " + pathInfo);
        out.println("Context Path: " + req.getContextPath());
        out.println();

        // Check if resource exists in various locations
        out.println("=== Checking Resource Locations ===");

        // 1. Check webapp directory
        String webappPath = "/static" + (pathInfo != null ? pathInfo : "");
        URL webappResource = getServletContext().getResource(webappPath);
        out.println("Webapp resource (" + webappPath + "): " +
                (webappResource != null ? "FOUND at " + webappResource : "NOT FOUND"));

        // 2. Check classpath - try multiple variations
        String[] classpathPaths = {
                "template" + (pathInfo != null ? pathInfo : ""),
                "static" + (pathInfo != null ? pathInfo : ""),
                "/template" + (pathInfo != null ? pathInfo : ""),
                "/static" + (pathInfo != null ? pathInfo : ""),
                "META-INF/resources/template" + (pathInfo != null ? pathInfo : ""),
                "META-INF/resources/static" + (pathInfo != null ? pathInfo : "")
        };

        out.println("\n=== Classpath Resource Check ===");
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        for (String cpPath : classpathPaths) {
            URL cpResource = cl.getResource(cpPath);
            out.println("Classpath (" + cpPath + "): " +
                    (cpResource != null ? "FOUND at " + cpResource : "NOT FOUND"));

            // Also try as stream
            InputStream stream = cl.getResourceAsStream(cpPath);
            if (stream != null) {
                out.println("  -> Also found as stream!");
                stream.close();
            }
        }

        // 3. List all JARs containing 'jquery' in the classpath
        out.println("\n=== jQuery-related JARs in Classpath ===");
        Enumeration<URL> jars = cl.getResources("META-INF/MANIFEST.MF");
        while (jars.hasMoreElements()) {
            URL jarUrl = jars.nextElement();
            String jarPath = jarUrl.toString();
            if (jarPath.contains("jquery") || jarPath.contains("struts2")) {
                out.println("Found JAR: " + jarPath);

                // Check if this JAR contains our resource
                if (jarPath.startsWith("jar:")) {
                    String jarBase = jarPath.substring(0, jarPath.indexOf("!/"));

                    // Test multiple paths
                    String[] testPaths = {
                            "!/template/js/struts2/jquery.struts2.min.js",
                            "!/template/js/base/jquery-3.7.1.min.js",
                            "!/template/js/plugins/jquery.subscribe.min.js"
                    };

                    for (String testPath : testPaths) {
                        try {
                            URL testUrl = new URL(jarBase + testPath);
                            InputStream is = testUrl.openStream();
                            if (is != null) {
                                is.close();
                                out.println("  -> Contains: " + testPath.substring(2));
                            }
                        } catch (Exception e) {
                            // Resource not in this JAR
                        }
                    }
                }
            }
        }

        // 4. Check Struts2 configuration
        out.println("\n=== Struts2 Configuration ===");
        out.println("struts.serve.static: " +
                getServletContext().getInitParameter("struts.serve.static"));
        out.println("System property struts.serve.static: " +
                System.getProperty("struts.serve.static"));

        // 5. Check ClassLoader hierarchy
        out.println("\n=== ClassLoader Hierarchy ===");
        ClassLoader currentCL = Thread.currentThread().getContextClassLoader();
        int level = 0;
        while (currentCL != null) {
            out.println("Level " + level + ": " + currentCL.getClass().getName() + " - " + currentCL);
            currentCL = currentCL.getParent();
            level++;
        }

        // 6. Try to load a specific resource directly
        out.println("\n=== Direct Resource Loading Test ===");
        String testResource = "template/js/struts2/jquery.struts2.min.js";
        URL directResource = cl.getResource(testResource);
        out.println("Direct load of " + testResource + ": " +
                (directResource != null ? "SUCCESS - " + directResource : "FAILED"));

        out.flush();
    }
}