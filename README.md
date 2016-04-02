ADB Idea
========

A plugin for Android Studio and Intellij IDEA that speeds up your day to day android development.

The following commands are provided:

* Uninstall App
* Kill App
* Start App
* Restart App
* Clear App Data
* Clear App Data and Restart

Usage
=====

Quick Operations Popup
-----------------

The number on the left is a shortcut that will stay the same for your muscle memory pleasure.

* Mac OSX: Ctrl+Shift+A
* Windows/Linux: Ctrl+Alt+Shift+A

![Logo](website/adb_operations_popup.png)

Find Actions
-----------------
Each command is prefixed by "ADB", so you can quickly filter through adb commands using the "[Find Actions](http://www.jetbrains.com/idea/webhelp/navigating-to-action.html)" shortcut. 

![Logo](website/find_actions.png)

The Menu Way
------------
You can find every command in the following menu:
`Tools->Android->ADB Idea` 


Installation
========

Download and install *ADB Idea* directly from Intellij / Android Studio:
`Preferences/Settings->Plugins->Browse Repositories` 

Alternatively, you can [dowload the plugin](http://plugins.jetbrains.com/plugin/7380?pr=idea) from the jetbrains plugin site and install it manually in:
`Preferences/Settings->Plugins->Install plugin from disk` 

License
=======

    Copyright 2014 Philippe Breault

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

Build
=====
Run <code>./gradlew buildPlugin</code>
It will produce the build/distributions/adb_idea-1.3.0.zip  file.
Open android studio, and install it from a zip file.
Details
-------

Gradle build will employ the intellij gradle plugin https://github.com/JetBrains/gradle-intellij-plugin.
This plugin will attempt to download a full binary of the intellij idea in order to build its plugin against it.

But what we need is somewhere else. Download Android Studio 2.1 preview 5 from http://tools.android.com/download/studio/canary. Unzip it and find the android.jar file. Then copy it onto the lib/ folder.

Note: on Mac it's available at /Applications/Android Studio beta.app/Contents/plugins/android/lib/android.jar. On linux it's certainly on a similar location.


What's this about: git clone git://git.jetbrains.org/idea/android.git --depth 1 --single-branch ????

On compiling Android Studio from source
=======================================

This is the official page for compiling Android Studio things http://tools.android.com/build. TL;DR, see detailed instructions below.

Get source code
---------------

Get repo tool

<code>curl https://storage.googleapis.com/git-repo-downloads/repo > ~/bin/repo</code>

<code>chmod a+x ~/bin/repo</code>

Use repo tool to download android studio source code in the bleeding edge branch

<code>mkdir studio-master-dev; cd studio-master-dev</code>

<code>repo init -u https://android.googlesource.com/platform/manifest -b studio-master-dev</code>

or to get only the 1.5 version

<code>repo init -u https://android.googlesource.com/platform/manifest -b studio-1.5</code>


Download everything in 8 different threads.
<code>repo sync -j8</code>.

Note that this will take a very long time, and I strongly recomment that you get a steady uninterrupted internet connection and avoid your computer from sleeping until it's finished. I've experienced problems with interrupted git downloads, so it's not a problem with the repo tool.






