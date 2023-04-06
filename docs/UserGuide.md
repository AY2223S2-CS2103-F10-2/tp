---
layout: page
title: User Guide
---

![Logo](images/LogoWordmark.png)

## Welcome to **Le Tracker**!

> “The tragedy in life doesn’t lie in not reaching your goal. The tragedy lies in having no goal to reach.” - Benjamin E. Mays

School is hard. With numerous modules to juggle and endless topics to master, being a student can feel overwhelming at times. But does this *truly* need to be the case?

We believe that with a little help, content mastery is **more than achievable**.
> “You don't actually do a project; you can only do action steps related to it. When enough of the right action steps have been taken, some situation will have been created that matches your initial picture of the outcome closely enough that you can call it "done.”
― David Allen, Getting Things Done: The Art of Stress-Free Productivity

**Le Tracker** makes it easy to measure your overall study progress by tracking how much lecture content you have covered across various modules. **More** than just a simple to-do list app, **Le Tracker** blends the **efficiency** of a command line interface with the **elegance** of modern graphical user interface.

Now it's time to **CONQUER** the semester!

## Table of Contents

- [Welcome to **Le Tracker**!](#welcome-to-le-tracker)
- [Table of Contents](#table-of-contents)
- [Quick Start Guide](#quick-start-guide)
  - [Prerequisite](#prerequisite)
  - [Installation and Setup](#installation-and-setup)
  - [Getting Started](#getting-started)
  - [A Brief Guide to Navigation](#a-brief-guide-to-navigation)
  - [Tutorials and Examples](#tutorials-and-examples)
- [Command Syntax](#command-syntax)
- [Argument Formats](#argument-formats)
- [Navigation](#navigation)
- [Command Manual](#command-manual)
  - [Nav](#nav)
  - [List Modules or Lectures or Videos](#list-modules-or-lectures-or-videos)
  - [List Modules](#list-modules)
  - [List Lectures of Modules](#list-lectures-of-modules)
  - [List Videos of Lectures](#list-videos-of-lectures)
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
  - [Find Modules or Lectures or Videos](#find-modules-or-lectures-or-videos)
  - [Find Modules or Lectures or Videos By Tag](#find-modules-or-lectures-or-videos-by-tag)
  - [Find Lectures in a Module](#find-lectures-in-a-module)
  - [Find Lectures in a Module By Tag](#find-lectures-in-a-module-by-tag)
  - [Find Videos in a Lecture](#find-videos-in-a-lecture)
  - [Find Videos in a Lecture By Tag](#find-videos-in-a-lecture-by-tag)
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

### Getting Started

1. Type anything in the command box, using the :arrow_up: and :arrow_down: arrows to toggle through the texts you have typed.

2. Press `Enter` to execute a command.\
   For example, typing "help" and pressing `Enter` will open the help window.

### A Brief Guide to Navigation
**Context Indicator** - Displays which context you are currently working at.

![ContextLabel](images/ContextLabelScreenshot.png)

**Navigating** to different contexts:

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

:clap: That covers all the main commands. Refer to the [Features](#features) section for details of each command.\
Feel free to play around with the sample data to familiarise yourself with the commands. Once you are comfortable, execute `clear` to delete all data and start from scratch, challenge yourself without using the `import` command :wink:

---

## Command Syntax

**:information_source: The following are rules applicable to all commands:**

<p>

1. Words encapsulated in `{}` are placeholders for some actual value. In a command format, they represent the argument values to be supplied by the user.
   <details>
   <summary>Example</summary>
   For a command with format `add {module_code}`, `{module_code}` is an argument value. The command can be used as `add CS2040`.
   </details>

</p>

<p>

2. Items in square brackets are optional.
   <details>
   <summary>Example</summary>
   For a command with format `add {module_code} [/name {module_name}]`, the `/name` argument is optional. The command can be used as `add CS2040 /name Data Structures and Algorithms` or as `add CS2040`.
   </details>

</p>

<p>

3. Named arguments can be specified in any order as long as it is after all unnamed arguments (if any).
   <details>
   <summary>Example</summary>
   For a command with format `edit {module_code} /code {updated_code} /name {updated_name}`, `{module_code}` is an unnamed argument, while `/code` and `/name` are named arguments. The command can be used as `edit CS2040 /code CS2040S /name DSAG` or as `edit CS2040 /name DSAG /code CS2040S`.
   </details>

</p>

<p>

4. If a named argument is expected only once in the command but the user specified it multiple times, only the last occurrence of the argument will be taken.
   <details>
   <summary>Example</summary>
   For a command with format `add {module_code} [/name {module_name}]`, if used as `add CS2040 /name Data Structures and Algorithms /name DSAG`, `DSAG` will be taken as the value of the `/name` argument.
   </details>

</p>

<p>

5. Extraneous arguments will be ignored.
   <details>
   <summary>Example</summary>
   For a command with format `add {module_code} /name {module_name}`, if used as `add CS2040 /name DSAG /foo bar`, the `/foo` argument is ignored.
   </details>

</p>

<p>

6. Any occurrence of `/{argument_name}`, where `{argument_name}` contains only alphabetical characters (a-z or A-Z), will be treated as a named argument if there is a whitespace before `/{argument_name}` and `/{argument_name}` is followed by a whitespace unless it is the end of the command.
   <details>
   <summary>Example</summary>
   For the command `find Intro /mod CS2040S /byTag`, `/mod` and `/byTag` are both recognised as named arguments.

   For the command `find Intro /modCS2040S /byTag`, only `/byTag` is recognised as a named argument while `Intro /modCS2040S` is treated as the value of the unnamed argument.
   </details>

</p>

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
Le Tracker organises content using a **hierarchical structure** (Modules -> Lectures -> Videos).

![RootContext](images/RootContext.png)
![ModContext](images/ModContext.png)
![LectureContext](images/LectureContext.png)

When you are studying a specific lecture topic (e.g. Week 1 of CS2040S), you may find yourself frequently performing commands that are related to the module CS2040S and lecture Week 1.

To avoid the need to constantly specify the module and lecture parameters for such commands, the navigation system allows you to specify your current working context instead. This context will allow the navigation system to inject the required module and lecture parameters into commands for you.

The user can specify their current working context by navigating through the hierarchy. For example, the user can navigate to the *lecture Week 1 of the module CS2040S* by:

![RootContext](images/RootContext.png)
Navigating **relatively** from the **root context**:
1. Navigate to the module context from the root context.
- `nav CS2040S`
2. Navigate to the lecture context from the module context.
- `nav Week 1`

*OR*

![RootContext](images/RootContext.png)
![ModContext](images/ModContext.png)
![LectureContext](images/LectureContext.png)
Navigating **directly** from any **context**:
1. Navigate directly to the lecture Week 1 of the module CS2040S.
- `nav /mod CS2040S /lec Week 1

After navigating to specific context, the navigation system can specify module and lecture parameters so that you don't have to!

Here are some **examples** of how the navigation system injects the necessary context-related parameters into your commands:
1. Add Video 2 to the lecture Week 1 of module CS2040S.
- `add Video 2` -> `add Video 2 /mod CS2040S /lec Week 1`
2. List the contents of lecture Week 1 of module CS2040S.
- `list` -> `list /mod CS2040S /lec Week 1`

---

## Command Manual

### Nav
**Navigate to the Root Context**

> Sets the current context to the root context

Format: `nav`

**Navigate Relatively**

> Navigates relative to the current context to a module or lecture context

Format: `nav {module_code / lecture_name}`

- `module_code` has to belong to an existing module that is a child of the current context
- `lecture_name` has to belong to an existing lecture that is a child of the current context

**Navigate Directly**

> Navigates directly to the specified module or lecture context

Format: `nav /mod {module_code / lecture_name} [/lec {lecture_name}]`

- `module_code` has to belong to an existing module
- `lecture_name` has to belong to an existing lecture

**Navigate Backwards**

> Navigates to the parent context of the current context

Format: `navb`

### List Modules or Lectures or Videos

> `list`

Root context: modules, Module context: lectures, Lecture context: videos

:information_source: The navigation system might specify the `/mod` and `/lec` arguments which will transform the user's command into the command specified in [List Lectures of Modules](#list-lectures-of-modules) or [List Videos of Lectures](#list-videos-of-lectures) (refer to [Navigation](#navigation) for more information)

### List Modules

> `list /r`

Lists all modules

### List Lectures of Modules

> `list [/mod {module_code}]`

Lists all lectures belonging to a specified module code

- <span style="color:#e46c0a">`module_code`</span> : The code of the module that contains the lecture specified in `lecture_name`
  - Must belong to an existing module in Le Tracker (:exclamation:Module code matching is case sensitive)
  - Might be automatically specified by the navigation system (refer to [Navigation](#navigation) for more information)

Examples:

- `list /mod CS2040S` lists lectures belonging to CS2040S

### List Videos of Lectures

> In module context: `list [/lec {lecture_name}]`\
> In any context: `list [/mod {module_code} /lec {lecture_name}]`

Lists all videos belonging to a specified lecture code of a navigated/specified module code

- <span style="color:#e46c0a">`module_code`</span> : The code of the module that contains the lecture specified in `lecture_name`
  - Must belong to an existing module in Le Tracker (:exclamation:Module code matching is case sensitive)
  - Might be automatically specified by the navigation system (refer to [Navigation](#navigation) for more information)
- <span style="color:#e46c0a">`lecture_name`</span> : The name of the lecture
  - Must be unique among the names of the lectures belonging to the module specified in `module_code` (:exclamation:Uniqueness is case sensitive)
  - Refer to [Argument Formats](#argument-formats) for the "Lecture Name" format

Examples:

- In module context of module `CS2040S`: `list /lec Week 1`
- In any context: `list /mod CS2040 /lec Week 1`

_\* Both commands lists videos that belongs to lecture `Week 1` in module `CS2040S`_

### Add a Module

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
When in a module or lecture context, the navigation system will inject the `/mod` and `/lec` arguments transforming the user's command into the command specified in [Add a Lecture](#add-a-lecture) or [Add a Video](#add-a-video) (refer to [Navigation](#navigation) for more information)

### Add a Lecture

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

:information_source: The navigation system might specify the `/lec` argument which will transform the user's command into the command specified in [Add a Video](#add-a-video) (refer to [Navigation](#navigation) for more information)

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

### Edit a Lecture

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

### Edit a Video

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

### Find Modules or Lectures or Videos

> `find {keywords}`

Find all modules/lectures/videos based on context whose code/name (whichever applicable) starts with any of the keyword(s) and case is insensitive.

Examples:

- In root level, `find CS2040S` searches for module `CS2040S` from the module list.
- In module level within `CS2040S`, `find week 1, week 2` searches for lectures `week 1` or `week 2` from the lecture list of module `CS2040S`.
- In lecture level within `week2` of `CS2040S`, `find vid1, vid2` searches for videos `vid1` or `vid2` from the video list of lecture `week2` of module `CS2040S`.

:information_source: The navigation system might specify the `/mod` and `/lec` arguments which will transform the user's command into the command specified in [Find Lectures in a Module](#find-lectures-in-a-module) or [Find Videos in a Lecture](#find-videos-in-a-lecture) (refer to [Navigation](#navigation) for more information)

### Find Modules or Lectures or Videos By Tag

> `find {keywords} [/byTag]`

Find all modules/lectures/videos based on context whose tag list contains any tag that starts with any of the keyword(s)

**Assumption:**\
Module `CS2040S` has tags `["heavy", 'math']`\
Lecture `Week 1` of `CS2040S` has tags `["Arrays", "Sorting"]`\
Video `Vid 1` of `Week 1` of `CS2040S` has tags `["content"]`

Examples:

- In root level, `find heavy /byTag` will show module `CS2040S` from the module list.
- In module level within `CS2040S`, `find array /byTag` will show lecture `Week 1` from the lecture list of module `CS2040S`.
- In lecture level within `Week 1` of `CS2040S`, `find cont /byTag` will show video `Vid 1` from the video list of lecture `Week 1` of module `CS2040S`.

### Find Lectures in a Module

> `find {keywords} [/mod {module_code}]`

Find all lectures in a specified module whose name starts with any of the keyword(s)

- <span style="color:#e46c0a">`module_code`</span> : The code of the module that contains the lecture specified in `lecture_name`
  - Must belong to an existing module in Le Tracker (:exclamation:Module code matching is case sensitive)
  - Might be automatically specified by the navigation system (refer to [Navigation](#navigation) for more information)

Examples:

- `find week 1, week 2 /mod CS2040S` searches for lectures `Week 1` or `Week 2` from the lecture list of module `CS2040S`.

### Find Lectures in a Module By Tag

> `find {keywords} [/byTag /mod {module_code}]`

Find all lectures in a specifed module whose tag list contains any tag that starts with any of the keyword(s)

- <span style="color:#e46c0a">`module_code`</span> : The code of the module that contains the lecture specified in `lecture_name`
  - Must belong to an existing module in Le Tracker (:exclamation:Module code matching is case sensitive)
  - Might be automatically specified by the navigation system (refer to [Navigation](#navigation) for more information)

**Assumption:**\
Module `CS2040S` has lecture `Week 1` which has tags `["array", 'sorting']`

Examples:

- `find intro, array /byTag /mod CS2040S` will show lecture `Week 1` from the lecture list of module `CS2040S`.

### Find Videos in a Lecture

> In module context: `find {keywords} [/lec {lecture_name}]`\
> In any context: `find {keywords} [/mod {module_code} /lec {lecture_name}]`

Find all videos in a specified lecture in a navigated/specified module whose name starts with any of the keyword(s)

- <span style="color:#e46c0a">`module_code`</span> : The code of the module that contains the lecture specified in `lecture_name`
  - Must belong to an existing module in Le Tracker (:exclamation:Module code matching is case sensitive)
  - Might be automatically specified by the navigation system (refer to [Navigation](#navigation) for more information)
- <span style="color:#e46c0a">`lecture_name`</span> : The name of the lecture
  - Must be unique among the names of the lectures belonging to the module specified in `module_code` (:exclamation:Uniqueness is case sensitive)
  - Refer to [Argument Formats](#argument-formats) for the "Lecture Name" format

Examples:

- In module context of module `CS2040S`: `find vid1, vid2 /lec Week 2`
- In any context: `find vid1, vid2 /mod CS2040S /lec Week 2`

_\* Both commands searches for videos `vid1` or `vid2` from the video list of lecture `Week 2` of module `CS2040S`_

### Find Videos in a Lecture By Tag

> In module context: `find {keywords} [/byTag /lec {lecture_name}]`\
> In any context: `find {keywords} [/byTag /mod {module_code} /lec {lecture_name}]`

Find all videos in a specified lecture in a navigated/specified module whose tag list contains any tag that starts with any of the keyword(s)

- <span style="color:#e46c0a">`module_code`</span> : The code of the module that contains the lecture specified in `lecture_name`
  - Must belong to an existing module in Le Tracker (:exclamation:Module code matching is case sensitive)
  - Might be automatically specified by the navigation system (refer to [Navigation](#navigation) for more information)
- <span style="color:#e46c0a">`lecture_name`</span> : The name of the lecture
  - Must be unique among the names of the lectures belonging to the module specified in `module_code` (:exclamation:Uniqueness is case sensitive)
  - Refer to [Argument Formats](#argument-formats) for the "Lecture Name" format

**Assumption:**\
Module `CS2040S` has lecture `Week 2` which has video `Vid 1` which has tags `["content"]`

Examples:

- In module context of module `CS2040S`: `find content /byTag /lec Week 2`
- In any context: `find content /byTag /mod CS2040S /lec Week 2`

_\* Both commands will show video `Vid 1` from the video list of lecture `Week 2` of module `CS2040S`_

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
