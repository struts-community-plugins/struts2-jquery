# Struts2 jQuery Plugin

[![Maven Central](https://maven-badges.sml.io/sonatype-central/com.jgeppert.struts2.jquery/struts2-jquery/badge.svg)](https://maven-badges.sml.io/sonatype-central/com.jgeppert.struts2.jquery/struts2-jquery)
[![Java CI with Maven](https://github.com/struts-community-plugins/struts2-jquery/actions/workflows/maven.yml/badge.svg)](https://github.com/struts-community-plugins/struts2-jquery/actions/workflows/maven.yml)

A Plugin for the popular java web framework struts2 to provide ajax functionality and UI Widgets based on the jQuery javascript framework.

#### [Download] (https://oss.sonatype.org/content/groups/staging/com/jgeppert/struts2/jquery/)
#### [News and Developer Blog] (https://www.jgeppert.com)
#### [Showcase] (https://struts.jgeppert.com/struts2-jquery-showcase/)
#### [Showcase Grid Plugin] (https://struts.jgeppert.com/struts2-jquery-grid-showcase/)
#### [Sample TODO app based on Bootstrap, jQuery and jQuery Mobile] (https://github.com/jogep/struts2-todo-examples/)
#### [Wiki - Documentation] (https://github.com/struts-community-plugins/struts2-jquery/wiki)

## Installation

### How can I use the Plugin?

  * [Download](https://oss.sonatype.org/content/groups/staging/com/jgeppert/struts2/jquery/) the struts2-jquery-plugin-x.x.x.jar
  * Put it into your Classpath (WEB-INF/lib)
  * Add the Tag-Lib to your JSP `<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>`
  * Place the [HeadTag Head Tag] inside your html head tags

### versions and compatibility
| `struts2-jquery` version | `struts2` version               | `Java` version   |
|--------------------------|---------------------------------|------------------|
| `6.1.0`                  | version >= `7.2.1`              | version >= `17`  |
| `6.0.0`                  | version >= `7.0.0`              | version >= `17`  |
| `5.0.7`                  | version >= `6.7.0`              | version >= `1.8` |
| `5.0.6`                  | version >= `6.6.0`              | version >= `1.8` |
| `5.0.2`                  | version >= `6.1`                | version >= `1.8` |
| `5.0.0`                  | version >= `6.0`                | version >= `1.8` |
| `4.0.3`                  | version >= `2.5`                | version >= `1.7` |
| `3.7.1`                  | `2.3.16` <= version <= `2.3.31` | version >= `1.5` |

As a general rule of thumb, it's advised to upgrade to the latest version within the same major version range. This should avoid bugs and vulnerabilities that already got fixed in more recent versions.

See [Changelog](https://github.com/struts-community-plugins/struts2-jquery/wiki/Changelog) for more information

### How can I use the Plugin from Maven?

Since version 1.8.3 the plugin is found in the central Maven repository. Just add to your dependencies section:

```xml
<dependencies>
    ...
    <dependency>
        <groupId>com.jgeppert.struts2.jquery</groupId>
        <artifactId>struts2-jquery-plugin</artifactId>
        <version>6.0.2</version>
    </dependency>
    <dependency>
        <groupId>com.jgeppert.struts2.jquery</groupId>
        <artifactId>struts2-jquery-grid-plugin</artifactId>
        <version>6.0.2</version>
    </dependency>
    <dependency>
        <groupId>com.jgeppert.struts2.jquery</groupId>
        <artifactId>struts2-jquery-datatables-plugin</artifactId>
        <version>6.0.2</version>
    </dependency>
    <dependency>
        <groupId>com.jgeppert.struts2.jquery</groupId>
        <artifactId>struts2-jquery-richtext-plugin</artifactId>
        <version>6.0.2</version>
    </dependency>
    <dependency>
        <groupId>com.jgeppert.struts2.jquery</groupId>
        <artifactId>struts2-jquery-tree-plugin</artifactId>
        <version>6.0.2</version>
    </dependency>
    ...
</dependencies>
```

To access SNAPSHOT builds, you need to declare the snapshot repository lookup in your pom.xml:

```xml
...
<repositories>
    ...
  <repository>
    <name>Central Portal Snapshots</name>
    <id>central-portal-snapshots</id>
    <url>https://central.sonatype.com/repository/maven-snapshots/</url>
    <releases>
      <enabled>false</enabled>
    </releases>
    <snapshots>
      <enabled>true</enabled>
    </snapshots>
  </repository>
</repositories>
...
```

## WebJars

Since **Struts 7.3.0** WebJars are supported by `struts2-core` itself, so any application built on
`struts2-jquery` `6.x` can serve client-side libraries straight from a WebJar without extra plumbing.
`org.webjars:webjars-locator-lite` is a transitive dependency of `struts2-core` — nothing else needs to
be added to the classpath.

Declare the WebJar you want:

```xml
<dependency>
    <groupId>org.webjars</groupId>
    <artifactId>jquery</artifactId>
    <version>3.7.1</version>
</dependency>
```

Its assets are then served below the Struts static content path, under `/webjars/**`. Both the
version-less and the versioned form resolve to the same resource:

```
/<context>/static/webjars/jquery/jquery.min.js
/<context>/static/webjars/jquery/3.7.1/jquery.min.js
```

Rather than hardcoding the URL, use the `<s:webjar>` tag from the Struts tag library. It takes a
version-less path and renders the full, versioned URL including the context path:

```jsp
<%@ taglib prefix="s" uri="/struts-tags" %>

<script src="<s:webjar path='jquery/jquery.min.js'/>"></script>
```

renders

```html
<script src="/myapp/static/webjars/jquery/3.7.1/jquery.min.js"></script>
```

The tag also accepts `var`, to put the URL on the value stack instead of writing it out:

```jsp
<s:webjar path="jquery/jquery.min.js" var="jqueryUrl"/>
```

Two settings control the feature:

| Setting                    | Default | Description                                                       |
|----------------------------|---------|-------------------------------------------------------------------|
| `struts.webjars.enabled`   | `true`  | Master switch for resolving and serving WebJar assets              |
| `struts.webjars.allowlist` | *empty* | Comma-separated list of WebJar names to expose; empty means all    |

In a hardened setup it is worth restricting the allowlist to the WebJars you actually use:

```
struts.webjars.allowlist=jquery,jquery-ui
```

Note that the `<sj:head>` tag continues to serve the jQuery and jQuery UI copies bundled inside
`struts2-jquery-plugin`, and is not affected by these settings. WebJars are the recommended way to add
*further* client-side libraries to your application.
