---
layout: page
title: User Guide
---

![Logo](images/LogoWordmark.png)

## Welcome to **Le Tracker** ~

> “The tragedy in life doesn’t lie in not reaching your goal. The tragedy lies in having no goal to reach.” - Benjamin E. Mays

School is hard. With numerous modules to juggle and endless topics to master, being a student can feel overwhelming at times. But does this _truly_ need to be the case?

We believe that with a little help, content mastery is **more than achievable**.

> “You don't actually do a project; you can only do action steps related to it. When enough of the right action steps have been taken, some situation will have been created that matches your initial picture of the outcome closely enough that you can call it "done.”
> ― David Allen, Getting Things Done: The Art of Stress-Free Productivity

**Le Tracker** makes it easy to measure your overall study progress by tracking how much lecture content you have covered across various modules. **More** than just a simple to-do list app, **Le Tracker** blends the **efficiency** of a command line interface with the **elegance** of modern graphical user interface.

Now it's time to **CONQUER** the semester!

## Table of Contents

- [Quick Start Guide](#quick-start-guide)
  - [Prerequisite](#prerequisite)
  - [Installation and Setup](#installation-and-setup)
  - [User Interface and Getting Started](#user-interface-and-getting-started)
  - [A Brief Guide to Navigation](#a-brief-guide-to-navigation)
  - [Tutorials and Examples](#tutorials-and-examples)
- [Command Syntax](#command-syntax)
- [Argument Formats](#argument-formats)
- [Navigation](#navigation)
- [Command Manual](#command-manual)
  - [Nav](#nav)
  - [List](#list)
  - [Add a Module](#add-a-module)
  - [Add a Lecture](#add-a-lecture)
  - [Add a Video](#add-a-video)
  - [Edit a Module](#edit-a-module)
  - [Edit a Lecture](#edit-a-lecture)
  - [Edit a Video](#edit-a-video)
  - [Delete Module](#delete-module)
  - [Delete Lecture](#delete-lecture)
  - [Delete Video](#delete-video)
  - [Mark or Unmark Video](#mark-or-unmark-video)
  - [Tag a module](#tag-a-module)
  - [Tag a lecture](#tag-a-lecture)
  - [Tag a video](#tag-a-video)
  - [Untag a module](#untag-a-module)
  - [Untag a lecture](#untag-a-lecture)
  - [Untag a video](#untag-a-video)
  - [Find](#find)
  - [Clear all Modules](#clear-all-modules)
  - [Exit the App](#exit-the-app)
  - [Export Data](#export-data)
  - [Import Data](#import-data)
- [Note](#note)
- [Warning](#warning)
- [FAQ](#faq)

---

## Quick Start Guide

### Prerequisite

> Make sure you have Java `11` installed on your computer by typing `java --version` from your terminal.\
> If not, please download it from the [Oracle website](https://www.oracle.com/sg/java/technologies/javase/jdk11-archive-downloads.html).

### Installation and Setup

1. Download the latest version of [leTracker.jar](https://github.com/AY2223S2-CS2103-F10-2/tp/releases).

2. Open your terminal and navigate to the directory of the downloaded jar file.

3. Run the jar file by `java -jar leTracker.jar`.

### User Interface and Getting Started

![GettingAround](images/GettingAround.png)

1. Type anything in the command box, using the :arrow_up: and :arrow_down: arrows to toggle through the texts you have typed.

2. Press `Enter` to execute a command.\
   For example, typing "help" and pressing `Enter` will open the help window.

### A Brief Guide to Navigation

Current Working Context Indicator

- The **blue label** on the left of the command box displays your [current working context](#current-working-context).

- ![ContextLabel](images/ContextLabelScreenshot.png)

**Navigating** to different contexts

- Here are some ways you can **navigate** between different contexts.

![NavDiagram](images/NavDiagram.png)

For more information on **navigation**, please view the [navigation section](#navigation).

### Tutorials and Examples

Scenario 1 - Tracking a new module CS2103:

1. To add a module, run `add CS2103 /name Software Engineering`.
1. To give it a tag of `BestModule`, run `tag CS2103 /tags BestModule`.
1. To add a lecture, run `add Week 1 /mod CS2103`.
1. To add a video, run `add Vid 1 /mod CS2103 /lec Week 1`.
1. To add a timestamp, run `edit Vid 1 /mod CS2103 /lec Week 1 /timestamp 10:20:15`.
1. To view the list with this video, run `list /mod CS2103 /lec Week 1`.
1. To delete this module, run `delete CS2103`.

Scenario 2 - Navigating, finding & archiving data:

1. To navigate into module `CS2040S`, run `nav CS2040S`.
1. To find a lecture named `Week 1`, run `find Week 1`.
1. To find a video named `Vid 1` in `Week 1` lecture, run `find Vid 1 /lec Week 1`.
1. To navigate back to root context, run `nav` or `navb`.
1. To export all data, run `export data.json`.
1. To clear all data, run `clear`.
1. To import data, run `import data.json`.

Scenario 3 - Tracking videos:

1. To view lectures in module `ST2334`, run `list /mod ST2334`.
1. To delete a video `Vid 3` in lecture `Topic 1` in module `ST2334`, run `delete Vid 3 /mod ST2334 /lec Topic 1`
1. To navigate into lecture `Topic 2` in module `ST2334`, run `nav /mod ST2334 /lec Topic 2`.
1. To unmark a video `Vid 1` in lecture `Topic 2` in module `ST2334` as unwatched, run `unmark Vid 1`
1. To change the video name to `video 1`, run `edit Vid 1 /name video 1`
1. To delete this lecture, run `delete Topic 2 /mod ST2334`
1. To exit the app, run `exit`.

:clap: That covers all the main commands. Refer to the [Command Manual](#command-manual) section for details of each command.\
Feel free to play around with the sample data to familiarise yourself with the commands. Once you are comfortable, execute `clear` to delete all data and start from scratch, challenge yourself without using the `import` command :wink:

---

## Command Syntax

**:information_source: The following are rules applicable to all commands:**

1. Items in curly braces (i.e. `{}`) are placeholders for some actual value. In a command format, they represent the argument values to be supplied by the user.
   <details>
   <summary>Example</summary>
   For a command with format <code>add {module_code}</code>, <code>{module_code}</code> is an argument value. The command can be used as <code>add CS2040</code>.
   </details>

2. Items in square brackets (i.e. `[]`) are optional.
   <details>
   <summary>Example</summary>
   For a command with format <code>add {module_code} [/name {module_name}]</code>, the <code>/name</code> argument is optional. The command can be used as <code>add CS2040 /name Data Structures and Algorithms</code> or as <code>add CS2040</code>.
   </details>

3. Named arguments can be specified in any order as long as it is after all unnamed arguments (if any).
   <details>
   <summary>Example</summary>
   For a command with format <code>edit {module_code} /code {updated_code} /name {updated_name}</code>, <code>{module_code}</code> is an unnamed argument, while <code>/code</code> and <code>/name</code> are named arguments. The command can be used as <code>edit CS2040 /code CS2040S /name DSAG</code> or as <code>edit CS2040 /name DSAG /code CS2040S</code>.
   </details>

4. If a named argument is expected only once in the command but the user specified it multiple times, only the last occurrence of the argument will be taken.
   <details>
   <summary>Example</summary>
   For a command with format <code>add {module_code} [/name {module_name}]</code>, if used as <code>add CS2040 /name Data Structures and Algorithms /name DSAG</code>, <code>DSAG</code> will be taken as the value of the <code>/name</code> argument.
   </details>

5. Extraneous arguments will be ignored.
   <details>
   <summary>Example</summary>
   For a command with format <code>add {module_code} /name {module_name}</code>, if used as <code>add CS2040 /name DSAG /foo bar</code>, the <code>/foo</code> argument is ignored.
   </details>

6. Any occurrence of `/{argument_name}`, where `{argument_name}` contains only alphabetical characters (a-z, A-Z), will be treated as a named argument if there is a whitespace before `/{argument_name}` and `/{argument_name}` is followed by a whitespace or it is the end of the command.
   <details>
   <summary>Example</summary>
   For the command <code>find Intro /mod CS2040S /byTag</code>, <code>/mod</code> and <code>/byTag</code> are both recognised as named arguments.

   For the command <code>find Intro /modCS2040S /byTag</code>, only <code>/byTag</code> is recognised as a named argument while <code>Intro /modCS2040S</code> is treated as the value of the unnamed argument.
   </details>

---

## Argument Formats

- **Module Code**\
  Module codes should begin with uppercase alphabet characters, followed by numeric characters, optionally followed by more uppercase alphabet characters.

- **Module Name**\
  Module names should only contain alphanumeric characters and spaces, and it can be blank.

- **Lecture Name**\
  Lecture names should only contain alphanumeric characters and spaces, and it should not be blank.

- **Video Name**\
  Video names should only contain alphanumeric characters and spaces, and it should not be blank.

- **Tag**\
  Tags should only contain alphanumeric characters, and it should not be blank.

- **Timestamp**\
  Timestamp should be of the format `HH:mm:ss` where `HH` is the number of hours, `mm` is the number of minutes, and `ss` is number of seconds, each integer being exactly 2 digits long.

---

## Navigation

### Current Working Context

Le Tracker organises content using a **hierarchical structure** (Modules -> Lectures -> Videos).
When you are studying a specific lecture topic (e.g. Week 1 of CS2040S), you may find yourself frequently performing commands that are related to the module CS2040S and lecture Week 1.

To avoid the need to constantly specify the module and lecture parameters for such commands, the navigation system allows you to specify a **current working context** instead.

Type of contexts

- ![RootContext](images/RootContext.png) **Root context**: The default and top-most context.
- ![ModContext](images/ModContext.png) **Module context**: Represents a specified module.
- ![LectureContext](images/LectureContext.png) **Lecture context**: Represents a specified lecture that belongs to a specified module.

### Two Ways of Navigating

You can specify a current working context by **navigating**.

- There two ways of **navigating** - **relatively** or **directly**.

For example, you can navigate to the **lecture context** - lecture Week 1 of the module CS2040S by

- Navigating **relatively** from the **root context**
  ![RootContext](images/RootContext.png)

  1. Navigate to the module context from the root context.
  - `nav CS2040S`
  2. Navigate to the lecture context from the module context.
  - `nav Week 1`

- Navigating **directly** from any **context**
  ![RootContext](images/RootContext.png)![ModContext](images/ModContext.png)![LectureContext](images/LectureContext.png)
  1. Navigate directly to the lecture Week 1 of the module CS2040S.
  - `nav /mod CS2040S /lec Week 1`

### Navigation Injection

After navigating to a lecture or module context, the navigation system will **inject** the required module and lecture parameters (i.e. `/mod CS2040S`, `/lec Week`) into commands so you don't have to!

Here are some **examples** of how the navigation system injects the necessary context-related parameters into your commands:

  1. ![LectureContext](images/LectureContext.png)
    Add "Video 2" to the lecture Week 1 of module CS2040S.
    - `add Video 2` -> `add Video 2 /mod CS2040S /lec Week 1`
  2. ![LectureContext](images/LectureContext.png)
    List the videos of lecture Week 1 of module CS2040S.
    - `list` -> `list /mod CS2040S /lec Week 1`
  3. ![LectureContext](images/LectureContext.png)
    Add "Video 1" to lecture Week 1 of module CS2040S.
    - `add Video 1 /lec Week 1` -> `add Video 1 /mod CS2040S /lec Week 1`

### Specifying Your Own Context In Commands

To specify your own context for a command without any [injection](#navigation-injection), you can use the `/r`, `/mod`, `lec` prefixes in your commands.

The following can be performed at **any** [current working context](#current-working-context)

- Including the `/r` prefix will perform a command from the **root context**.
  - e.g. List all modules at the root context.
  - `list /r` -> `list`
- Including the `/mod` prefix will perform a command from the **module context**.
  - e.g. Add lecture "Week 10" for module CS2040S.
  - `add Week 10 /mod CS2040S` -> `add Week 10 /mod CS2040S` (No injection)
- Including the `/mod` and `/lec` prefixes will perform a command from the **lecture context**.
  - e.g. Add video "BST Challenge" for lecture Week 5 of module CS2040S.
  - `add BST Challenge /mod CS2040S /lec Week 5` -> `add BST Challenge /mod CS2040S /lec Week 5` (No injection)

To make it easier to specify that share the same module code as your current working context, the `/mod` prefix can be injected when only the `/lec` prefix is specified.

- e.g. List videos of lecture Week 5 of module CS2040S
- ![LectureContext](images/LectureContext.png) `list /lec Week 5` -> `list /mod CS2040S /lec Week 5`
- Note that the lecture week is different from the current working context and that only the `/mod` prefix has been injected into the command input.

---

## Command Manual

### Nav

#### Navigate to the Root Context

> `nav`

Navigate to the root context from any context.

#### Navigate From Root Context to Module Context

> `nav {module_code}`

Navigates from the root context to a module context.

- <span style="color:#e46c0a">`module_code`</span> : The code of the module to navigate to
  - Refer to [Argument Formats](#argument-formats) for the "Module Code" format

#### Navigate From Module Context to Lecture Context

> `nav {lecture_name}`

Navigates from a module context to a lecture context.

- <span style="color:#e46c0a">`lecture_name`</span> : The name of the lecture to navigate to
  - Must belong to an existing lecture in the module of the current working context (:exclamation:Lecture name matching is case sensitive)

#### Navigate Directly

> `nav /mod {module_code / lecture_name} [/lec {lecture_name}]`

Navigates directly to the specified module or lecture context

- <span style="color:#e46c0a">`module_code`</span> : The code of the module to navigate to
  - Refer to [Argument Formats](#argument-formats) for the "Module Code" format
- <span style="color:#e46c0a">`lecture_name`</span> : The name of the lecture to navigate to
  - Must belong to an existing lecture in the module specified in `module_code` (:exclamation:Lecture name matching is case sensitive)

#### Navigate Backwards

> `navb`

Navigates backwards to the a parent context unless already at root context

### List

> Items are listed in an alphabetical order sorted by `module_code` for `Module`, `lecture_name` for `Lecture` and `video_name` for `Video`.

#### List Modules

> `list`

![RootContext](images/RootContext.png)
has to be appended at the end of the command if you are not in the root context.

![ModContext](images/ModContext.png)
![LectureContext](images/LectureContext.png)
When in a module or lecture context, the navigation system will inject the `/mod` and `/lec` arguments transforming the user's command into the command specified in [List Lectures](#list-lectures) or [List Videos](#list-videos)

(refer to [Navigation](#navigation) for more information)

#### List Lectures

> `list /mod {module_code}`

Lists all lectures belonging to a specified module code

- <span style="color:#e46c0a">`module_code`</span> : The code of the module that contains the lecture specified in `lecture_name`
  - Must belong to an existing module in Le Tracker (:exclamation:Module code matching is case sensitive)
  - Might be automatically specified by the navigation system (refer to [Navigation](#navigation) for more information)

Examples:

- `list /mod CS2040S` lists lectures belonging to CS2040S

#### List Videos

> `list /mod {module_code} /lec {lecture_name}`

Lists all videos belonging to a specified lecture name of a specified module code

- <span style="color:#e46c0a">`module_code`</span> : The code of the module that contains the lecture specified in `lecture_name`
  - Must belong to an existing module in Le Tracker (:exclamation:Module code matching is case sensitive)
  - Might be automatically specified by the navigation system (refer to [Navigation](#navigation) for more information)
- <span style="color:#e46c0a">`lecture_name`</span> : The name of the lecture
  - Must be unique among the names of the lectures belonging to the module specified in `module_code` (:exclamation:Uniqueness is case sensitive)
  - Refer to [Argument Formats](#argument-formats) for the "Lecture Name" format
  - Might be automatically specified by the navigation system (refer to [Navigation](#navigation) for more information)

Examples:

- `list /mod CS2040 /lec Week 1`

### Add

#### Add a Module

> `add {module_code} [/name {name}] [/tags {tag_1}[, {tag_2}[, ...]]]`

Add a module to Le Tracker.

- <span style="color:#e46c0a">`module_code`</span> : The code of the module
  - Must be unique among the module code of the modules in Le Tracker
  - Refer to [Argument Formats](#argument-formats) for the "Module Code" format
- <span style="color:#e46c0a">`module_name`</span> : The name of the module
  - Refer to [Argument Formats](#argument-formats) for the "Module Name" format
- <span style="color:#e46c0a">`tag_1, tag_2, ...`</span> : The tags to apply to the module
  - Refer to [Argument Formats](#argument-formats) for the "Tag" format
  - Repeated tags (if any) will be ignored

Examples:

- `add CS2040S /name Data Structures and Algorithms /tags Heavy, Math, Analysis`

![ModContext](images/ModContext.png)
![LectureContext](images/LectureContext.png)
When in a module or lecture context, the navigation system will inject the `/mod` and `/lec` arguments transforming the user's command into the command specified in [Add a Lecture](#add-a-lecture) or [Add a Video](#add-a-video) (refer to [Navigation](#navigation-injection) for more information).

#### Add a Lecture

> `add {lecture_name} /mod {module_code} [/tags {tag_1}[, {tag_2}[, ...]]]`

Add a lecture to a module.

- <span style="color:#e46c0a">`lecture_name`</span> : The name of the lecture
  - Must be unique among the names of the lectures belonging to the module specified in `module_code` (:exclamation:Uniqueness is case sensitive)
  - Refer to [Argument Formats](#argument-formats) for the "Lecture Name" format
- <span style="color:#e46c0a">`module_code`</span> : The code of the module to add the lecture to
  - Must belong to an existing module in Le Tracker (:exclamation:Module code matching is case sensitive)
  - Might be automatically specified by the navigation system (refer to [Navigation](#navigation) for more information)
- <span style="color:#e46c0a">`tag_1, tag_2, ...`</span> : The tags to apply to the lecture
  - Repeated tags (if any) will be ignored
  - Refer to [Argument Formats](#argument-formats) for the "Tag" format

Examples:

- `add Week 1 /mod CS2040S /tags Intro, Important`

### Add a Video

> `add {video_name} /mod {module_code} /lec {lecture_name} [/timestamp {timestamp}] [/watch] [/tags {tag_1}[, {tag_2}[, ...]]]`

Add a video to a lecture.

- <span style="color:#e46c0a">`/watch`</span> : If specified, the video will be marked as "watched", else, it will be marked as "not watched"
- <span style="color:#e46c0a">`video_name`</span> : The name of the video
  - Must be unique among the names of the videos belonging to the lecture specified in `lecture_name` (:exclamation:Uniqueness is case sensitive)
  - Refer to [Argument Formats](#argument-formats) for the "Video Name" format
- <span style="color:#e46c0a">`module_code`</span> : The code of the module that contains the lecture specified in `lecture_name`
  - Must belong to an existing module in Le Tracker (:exclamation:Module code matching is case sensitive)
  - Might be automatically specified by the navigation system (refer to [Navigation](#navigation) for more information)
- <span style="color:#e46c0a">`lecture_name`</span> : The name of the lecture to add the video to
  - Must belong to an existing lecture in the module specified in `module_code` (:exclamation:Lecture name matching is case sensitive)
  - Might be automatically specified by the navigation system (refer to [Navigation](#navigation) for more information)
- <span style="color:#e46c0a">`timestamp`</span> : The timestamp of the video where the user last stopped watching at
  - Defaults to `00:00:00` if the `/timestamp` argument is not specified
  - Refer to [Argument Formats](#argument-formats) for the "Timestamp" format
- <span style="color:#e46c0a">`tag_1, tag_2, ...`</span> : The tags to apply to the video
  - Repeated tags (if any) will be ignored
  - Refer to [Argument Formats](#argument-formats) for the "Tag" format

Examples:

- `add Video 1 /mod CS2040S /lec Week 1 /timestamp 01:04:20 /watch /tags Intro, Short`

![ModContext](images/ModContext.png)
![LectureContext](images/LectureContext.png)
When in a module or lecture context, the `/mod` argument will be injected if only the `/mod` argument is omitted in the original command (refer to [Navigation](#navigation-injection) for more information).

### Edit a Module

> `edit {module_code} [/code {updated_code}] [/name {updated_name}] [/tags {tag_1}[, {tag_2}[, ...]]]`

Edit the details of a module.

- <span style="color:#e46c0a">`module_code`</span> : The code of the module to be edited
  - Must belong to an existing module in Le Tracker (:exclamation:Module code matching is case sensitive)
- <span style="color:#e46c0a">`updated_code`</span> : The updated module code
  - Must be unique among the module code of the modules in Le Tracker
  - Refer to [Argument Formats](#argument-formats) for the "Module Code" format
- <span style="color:#e46c0a">`updated_name`</span> : The updated module name
  - Must be a valid module name (refer to [Argument Formats](#argument-formats) for more information)
- <span style="color:#e46c0a">`tag_1, tag_2, ...`</span> : The tags that will replace the current tags applied to the module
  - Repeated tags (if any) will be ignored
  - Refer to [Argument Formats](#argument-formats) for the "Tag" format

Examples:

- `edit CS2040S /code CS2040 /name Data Structures and Algorithms /tags Heavy, Math, Analysis`

:information_source: The navigation system might specify the `/mod` and `/lec` arguments which will transform the user's command into the command specified in [Edit a Lecture](#edit-a-lecture) or [Edit a Video](#edit-a-video) (refer to [Navigation](#navigation) for more information)

#### Edit a Lecture

> `edit {lecture_name} /mod {module_code} [/name {updated_name}] [/tags {tag_1}[, {tag_2}[, ...]]]`

Edit the details of a lecture.

- <span style="color:#e46c0a">`lecture_name`</span> : The name of the lecture to be edited
  - Must belong to an existing lecture in the module specified in `module_code` (:exclamation:Lecture name matching is case sensitive)
- <span style="color:#e46c0a">`module_code`</span> : The code of the module that contains the lecture specified in `lecture_name`
  - Must belong to an existing module in Le Tracker (:exclamation:Module code matching is case sensitive)
  - Might be automatically specified by the navigation system (refer to [Navigation](#navigation) for more information)
- <span style="color:#e46c0a">`updated_name`</span> : The updated lecture name
  - Must be unique among the names of the lectures belonging to the module specified in `module_code` (:exclamation:Uniqueness is case sensitive)
  - Refer to [Argument Formats](#argument-formats) for the "Lecture Name" format
- <span style="color:#e46c0a">`tag_1, tag_2, ...`</span> : The tags that will replace the current tags applied to the lecture
  - Repeated tags (if any) will be ignored
  - Refer to [Argument Formats](#argument-formats) for the "Tag" format

Examples:

- `edit Week 1 /mod CS2040S /name Week 01 Introduction /tags Intro, Important`

:information_source: The navigation system might specify the `/lec` argument which will transform the user's command into the command specified in [Edit a Video](#edit-a-video) (refer to [Navigation](#navigation) for more information)

#### Edit a Video

> `edit {video_name} /mod {module_code} /lec {lecture_name} [/name {updated_name}] [/timestamp {updated_timestamp}] [/watch] [/unwatch] [/tags {tag_1}[, {tag_2}[, ...]]]`

Edit the details of a video.

- <span style="color:#e46c0a">`/watch`</span> : If specified, the video will be marked as "watched"
  - If this argument is specified, then `/unwatch` should not be specified
- <span style="color:#e46c0a">`/unwatch`</span> : If specified, the video will be marked as "not watched"
  - If this argument is specified, then `/watch` should not be specified
- <span style="color:#e46c0a">`video_name`</span> : The name of the video to be edited
  - Must belong to an existing video in the lecture specified in `lecture_name` (:exclamation:Video name matching is case sensitive)
- <span style="color:#e46c0a">`module_code`</span> : The code of the module that contains the lecture specified in `lecture_name`
  - Must belong to an existing module in Le Tracker (:exclamation:Module code matching is case sensitive)
  - Might be automatically specified by the navigation system (refer to [Navigation](#navigation) for more information)
- <span style="color:#e46c0a">`lecture_name`</span> : The name of the lecture that contains the video specified in `video_name`
  - Must belong to an existing lecture in the module specified in `module_code` (:exclamation:Lecture name matching is case sensitive)
  - Might be automatically specified by the navigation system (refer to [Navigation](#navigation) for more information)
- <span style="color:#e46c0a">`updated_name`</span> : The updated video name
  - Must be unique among the names of the videos belonging to the lecture specified in `lecture_name` (:exclamation:Uniqueness is case sensitive)
  - Refer to [Argument Formats](#argument-formats) for the "Video Name" format
- <span style="color:#e46c0a">`updated_timestamp`</span> : The updated timestamp of the video where the user last stopped watching at
  - Refer to [Argument Formats](#argument-formats) for the "Timestamp" format
- <span style="color:#e46c0a">`tag_1, tag_2, ...`</span> : The tags that will replace the current tags applied to the lecture
  - Repeated tags (if any) will be ignored
  - Refer to [Argument Formats](#argument-formats) for the "Tag" format

Examples:

- `edit Video 1 /mod CS2040S /lec Week 1 /name Video 01 Grade Breakdown /timestamp 01:04:20 /watch /tags Intro, Short`

### Delete Module

> Deletes the specified module(s) and all its embodied content from the application

Format: `delete {module_code_1}[, {module_code_2}[, {module_code_3}[, ...]]]`

- `module_code_1`, `module_code_2`, `module_code_3`, ...: Multiple modules can be specified to be deleted by specifying multiple module codes, separating them by commas(",")
- Module codes must be of valid format
- If any module specified does not exist, nothing changes within the model

Examples:

- `delete CS2040`
- `delete CS2040, ST2334`

### Delete Lecture

> Deletes the specified lecture(s) and all its embodied content from the same specified module

Format: `delete {lecture_name_1}[, {lecture_name_2}[, {lecture_name_3}[, ...]]] [/mod {module_code}]`

- `lecture_name_1`, `lecture_name_2`, `lecture_name_3`, ...: Multiple lectures within the same module can be specified to be deleted by specifying their lecture names, separating them by commas(",")
- `module_code` must be of valid format and have a module of `module_code` exist in Le Tracker
- Lecture names must be of valid format
- If any lecture specified does not exist within specified module, nothing changes within the model

Examples:

- `delete lecture 1 /mod CS2040` deletes `lecture 1` lecture found in module `CS2040`
- `delete lecture 1, lecture 2 /mod ST2334` deletes `lecture 1` and `lecture 2` lectures found in module `ST2334`

### Delete Video

> Deletes the specified video(s) and all its embodied content from the same specified lecture of the specified module

Format: `delete {video_name_1}[, {video_name_2}[, {video_name_3}[, ...]]] /mod {module_code} /lec {lecture_name}`

- `video_name_1`, `video_name_2`, `video_name_3`, ...: Multiple videos within the same lecture of a module can be specified to be deleted by specifying their video names, separating them by commas(",")
- `module_code` must be of valid format and have a module of `module_code` exist in Le Tracker
- `lecture_name` must be of valid format and have a lecture of `lecture_name` exist in module of `module_code`
- Video names must be of valid format
- If any video specified does not exist within the specified lecture of the specified module, nothing changes within the model

Examples:

- `delete video 3 /mod CS2040 /lec lecture 1` deletes `video 3` from lecture `lecture 1` of module `CS2040`
- `delete video 1, video 3 /mod CS2040 /lec lecture 1` deletes `video 1` and `video 3` from lecture `lecture 1` of module `CS2040`

### Mark or Unmark Video

> Marks/Unmarks video(s) as watched/unwatched in a lecture of its specified module.

Format:

- `mark {video_name} /mod {module_name} /lec {lecture_index}`
- `unmark {video_name} /mod {module_name} /lec {lecture_index}`

Parameters:

- `mark` marks `{video_name}` as watched
- `unmark` marks `{video_name}` as unwatched
- `{video_name}` can be names of multiple videos, separated by commas (",")
- if `{video_name}` contains repeated names, the repeats will be ignored

Note: Calling mark or unmark would only prompt an error for already marked or unmarked videos if calling on a single video, not when calling on multiple videos in one command

- `video_name_1`, `video_name_2`, `video_name_3`, ...: Multiple videos can be specified to be marked/unmarked by specifying multiple video names, separating them by commas(",")
- Video Names must be of valid format
- If any video specified does not exist or has already been marked or unmarked (accordingly to the command called), nothing changes within the model

- `mark Vid 1 /mod CS2040 /lec Week 1`
- `mark Vid 1, Vid 2 /mod CS2040 /lec Week 1`
- `unmark Vid 2 /mod CS2040 /lec Week 1`
- `unmark Vid 1, Vid 2 /mod CS2040 /lec Week 1`

### Tag a module

> Tag a specified module from the current list of modules in Le Tracker with descriptions

Format: `tag {module_code} /tags {tag_1}[, {tag_2}[, {tag_3}, ...]]]`

- `module_code` must belong to an existing module
- `tag_1, tag_2, ...` must be of correct format

Example:

- `tag EG2310 /tags fun, hard` tags the module `EG2310` with the tags `fun` and `hard`

### Tag a lecture

> Tag a specified lecture with descriptions

Format: `tag {lecture_name} [/mod {module_code}] /tags {tag_1}[, {tag_2}[, {tag_3}, ...]]]`

- `module_code` must belong to an existing module
- `module_code` if not specified, defaults to the module code of the module in the current context (if any)
- `lecture_name` must belong to an existing lecture in the specified module
- `tag_1, tag_2, ...` must be of correct format

Examples:

- `tag Lecture_1 /mod CS2040 /tags Yay` tags the lecture `Lecture_1` in the module `CS2040` with the tag
  `Yay`

### Tag a video

> Tag a specified video with descriptions

Format: `tag {video_name} [/lec {lecture_name}] [/mod {module_code}] /tags {tag_1}[, {tag_2}[, {tag_3}, ...]]]`

- `module_code` must belong to an existing module
- `module_code` if not specified, defaults to the module code of the module in the current context (if any)
- `lecture_name` must belong to an existing lecture in the specified module
- `lecture_name` if not specified, defaults to the lecture name of the module in the current context (if any)
- `video_name` must belong to an existing video in the specified lecture
- `tag_1, tag_2, ...` must be of correct format

Examples:

- `tag Video_1 /lec Lecture_1 /mod CS2040 /tags Yay` tags the video `Video_1` in the lecture `Lecture_1` of
  the module `CS2040` with the tag `Yay`

### Untag a module

> Remove specified tags from a specified module in the current list of modules in Le Tracker

Format: `untag {module_code} /tags {tag_1}[, {tag_2}[, {tag_3}, ...]]]`

- `module_code` must belong to an existing module
- `tag_1, tag_2, ...` must belong to existing tags of the specified module

Example:

- `untag EG2310 /tags fun, hard` removes the tags `fun` and `hard` from the module `EG2310`

### Untag a lecture

> Untag a specified lecture from a specified module with a description

Format: `untag {lecture_name} [/mod {module_code}] /tags {tag_1}[, {tag_2}[, {tag_3}, ...]]]`

- `module_code` must belong to an existing module
- `module_code` if not specified, defaults to the module code of the module in the current context (if any)
- `lecture_name` must belong to an existing lecture in the specified module
- `tag_1, tag_2, ...` must belong to existing tags of the specified lecture

Examples:

- `untag Lecture_1 /mod CS2040 /tags Yay` removes the tag `Yay` from the lecture `Lecture_1` in the module `CS2040`

### Untag a video

> Remove specified tags from video

Format: `untag {video_name} [/lec {lecture_name}] [/mod {module_code}] /tags {tag_1}[, {tag_2}[, {tag_3}, ...]]]`

- `module_code` must belong to an existing module
- `module_code` if not specified, defaults to the module code of the module in the current context (if any)
- `lecture_name` must belong to an existing lecture in the specified module
- `lecture_name` if not specified, defaults to the lecture name of the module in the current context (if any)
- `video_name` must belong to an existing video in the specified lecture
- `tag_1, tag_2, ...` must belong to existing tags of the specified video

Examples:

- `untag Video_1 /lec Lecture_1 /mod CS2040 /tags Yay` removes the tag `Yay` in the video `Video_1` of the
  lecture `Lecture_1` that belongs to the module `CS2040`

### Find

:exclamation: This is a case insensitive search and matches a target that starts with the search term.
E.g:
|Type|Data|Keyword|Matched|
|-|-|-|-|
|ModuleCode|[CS2040S, CS2103, ST2334, MA2001]|cs21|[CS2103]|
|LectureName|[Week 1, Week 2, Week 3]|week|[Week 1, Week 2, Week 3]|
|VideoName|[Video 1, Video 2, Some video]|video 1, some|[Video 1, Some video]|

#### Find Modules

> `find {keywords} [/byTag]`

Find all modules whose code starts with any of the keyword(s).

![RootContext](images/RootContext.png)
has to be appended at the end of the command if you are not in the root context.

![ModContext](images/ModContext.png)
![LectureContext](images/LectureContext.png)
When in a module or lecture context, the navigation system will inject the `/mod` and `/lec` arguments transforming the user's command into the command specified in [Find Lectures in a Module](#find-lectures-in-a-module) or [Find Videos in a Lecture](#find-videos-in-a-lecture) (refer to [Navigation](#navigation) for more information)

(refer to [Navigation](#navigation) for more information)

:exclamation: If `/byTag` is specified, the list filters for modules whose tag list contains any tag that starts with any of the keyword(s)

Examples:

Assuming a Module `CS2040S` has tags `["heavy", 'math']`,

- `find heav /byTag` will show module `CS2040S` in the list.

#### Find Lectures

> `find {keywords} /mod {module_code} [/byTag]`

Find all lectures in a specified module whose name starts with any of the keyword(s)

- <span style="color:#e46c0a">`module_code`</span> : The code of the module that contains the lecture specified in `lecture_name`
  - Must belong to an existing module in Le Tracker (:exclamation:Module code matching is case sensitive)
  - Might be automatically specified by the navigation system (refer to [Navigation](#navigation) for more information)

:exclamation: If `/byTag` is specified, the list filters for lectures in a specifed module whose tag list contains any tag that starts with any of the keyword(s)

Examples:

- `find week 1, week 2 /mod CS2040S`
- `find intro, array /mod CS2040S /byTag`

#### Find Videos

> `find {keywords} /mod {module_code} /lec {lecture_name} [/byTag]`

Find all videos in a specified lecture in a specified module whose name starts with any of the keyword(s)

- <span style="color:#e46c0a">`module_code`</span> : The code of the module that contains the lecture specified in `lecture_name`
  - Must belong to an existing module in Le Tracker (:exclamation:Module code matching is case sensitive)
  - Might be automatically specified by the navigation system (refer to [Navigation](#navigation) for more information)
- <span style="color:#e46c0a">`lecture_name`</span> : The name of the lecture
  - Must be unique among the names of the lectures belonging to the module specified in `module_code` (:exclamation:Uniqueness is case sensitive)
  - Refer to [Argument Formats](#argument-formats) for the "Lecture Name" format
  - Might be automatically specified by the navigation system (refer to [Navigation](#navigation) for more information)

:exclamation: If `/byTag` is specified, the list filters for videos in a specified lecture in a specified module whose tag list contains any tag that starts with any of the keyword(s)

Examples:

- `find vid1, vid2 /mod CS2040S /lec Week 2`
- `find content /mod CS2040S /lec Week 2 /byTag`

### Clear all Modules

> Clears all information (modules, lectures, videos, tags) from Le Tracker

Format:

- `clear`

- any following term entered after `clear` is ignored
- calling `clear` will result in an empty Tracker

### Exit the App

> `exit`

Exit the application.

### Export Data

<!-- TODO: fill this in -->

### Import Data

<!-- TODO: fill this in -->

---

## Note

- Saving the data\
  Le Tracker data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

- Editing the data file\
  Le Tracker data are saved as a JSON file `[JAR file location]/data/letracker.json`. Advanced users are welcome to update data directly by editing that data file.

---

## Warning

:warning: If your changes to the data file makes its format invalid, Le Tracker will discard all data and start with an empty data file at the next run.

---

## FAQ

**Q**: How do I transfer my data to another Computer?\
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous Le Tracker home folder.

---

<!-- TODO: Update this after user guide is finalised -->
<!-- ## Command summary

| Action            | Format, Examples                                                                                                                                      |
| ----------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Add a Module**  | `add-module /code {module_code} [/name {module_name}]` / e.g., `add-module /code CS2040 /name Data Structures & Algorithms`                           |
| **Add a Lecture** | `add-lecture /module {module_code}` / e.g., `add-lecture /module CS2040`                                                                              |
| **Add a Video**   | `add-video /module {module_name} /lecture {lecture_index} /video {video_name}` / e.g., `add-video /module CS2040 /lecture 1 /video lecture-01-part-1` |
| **Tag a Lecture** | `tag /module {module_code} /lecture {lecture_id} /description {tag_description}` / e.g, `tag /module CS2040 /lecture 1 /description Boohoo`           |
| **Delete a Tag**  | `untag /module {module_code} /lecture {lecture_id} /tag {tag_id}` / e.g,  `untag /module CS2040 /lecture 1 /tag 1`                                    | -->
