# Struts2 jQuery Plugin

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.jgeppert.struts2.jquery/struts2-jquery/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.jgeppert.struts2.jquery/struts2-jquery)
[![Build release/5.0.x](https://travis-ci.org/struts-community-plugins/struts2-jquery.svg?branch=release%2F5.0.x)](https://travis-ci.org/struts-community-plugins/struts2-jquery)

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
| `struts2-jquery` version | `struts2` version               |
|--------------------------|---------------------------------|
| `5.0.2`                  | version >= `6.1`                |
| `5.0.0`                  | version >= `6.0`                |
| `4.0.3`                  | version >= `2.5`                |
| `3.7.1`                  | `2.3.16` <= version <= `2.3.31` |

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
        <version>5.0.2</version>
    </dependency>
    <dependency>
        <groupId>com.jgeppert.struts2.jquery</groupId>
        <artifactId>struts2-jquery-grid-plugin</artifactId>
        <version>5.0.2</version>
    </dependency>
    <dependency>
        <groupId>com.jgeppert.struts2.jquery</groupId>
        <artifactId>struts2-jquery-datatables-plugin</artifactId>
        <version>5.0.2</version>
    </dependency>
    <dependency>
        <groupId>com.jgeppert.struts2.jquery</groupId>
        <artifactId>struts2-jquery-richtext-plugin</artifactId>
        <version>5.0.2</version>
    </dependency>
    <dependency>
        <groupId>com.jgeppert.struts2.jquery</groupId>
        <artifactId>struts2-jquery-tree-plugin</artifactId>
        <version>5.0.2</version>
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
        <id>sonatype.oss.snapshots</id>
        <name>Sonatype OSS Snapshot Repository</name>
        <url>http://oss.sonatype.org/content/repositories/snapshots</url>
        <releases>false</releases>
        <snapshots>true</snapshots>
    </repository>
</repositories>
...
```
