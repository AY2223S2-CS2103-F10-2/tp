---
layout: page
title: User Guide
---

LE TRACKER is a gamified tracking application that allows fast typist to easily log their lecture progress, search for lecture by mod code/ keywords/ topics for a stress-free learning environment. Unlike todo list applications, LE TRACKER is tailored to the needs of students; it provides additional information specific to lecture media such as watch progress and topics.

- Table of Contents
  - [Quick Start](#quick-start)
  - [Features](#features)

---

## Quick Start

1. Ensure you have Java `11` or above installed in your Computer.

2. Type the command in the command box.

3. Press Enter to execute it. e.g. typing help and pressing Enter will open the help window.

- Nav
  - `nav`: Navigates to the top-most context (root)
  - `nav {module_code / lecture_name}`: Navigates relative to the current context to a module or lecture context
  - `nav /mod {module_code / lecture_name} [/lec {lecture_name}]`: Navigates directly to the specified module or lecture context
  - `navb`: Navigates to the parent context of the current context
- List
  - `list`: Lists the names of all the recorded modules
  - `list [/mod {module_code}]`: Lists all the lectures in the specified module
  - `list [/mod {module_code} /lec {lecture_name}]`: Lists all the videos in the specified module and lecture
- Add
  - `add {module_code} [/name {module_name}]`: Adds a module to Le Tracker
  - `add {lecture_name} [/mod {module_code}]`: Adds a lecture to a module
  - `add {video_name} [/mod {module_code}] [/lec {lecture_name}]`: Adds a video to a lecture
- Edit
  - `edit {module_code} [/code {updated_code}] [/name {updated_name}]`: Edits the details of a module in Le Tracker
  - `edit {lecture_name} [/mod {module_code}] [/name {updated_name}]`: Edits the details of a lecture
  - `edit {video_name} [/mod {module_code}] [/lec {lecture_name}] [/name {updated_name}]`: Edits the details of a video
- Mark/Unmark
  - `mark /module {module_code} /lecture {lecture_index} /video {video_name}`: Marks a video as watched
  - `unmark /module {module_code} /lecture {lecture_index} /video {video_name}`: Unmarks a video as unwatched
- Delete
  - `delete-module {module_code}`: Deletes a module from Le Tracker
  - `delete-lecture /module {module_code} /lecture {lecture_id}`: Deletes the specified lecture from the specified module
  - `delete-video /module {module_code} /lecture {lecture_id} /video {video_id}`: Deletes the specified video from the specified lecture from the specified module
- Tag
  - `tag {module_code} /tags {tag_1}[, {tag_2}[, {tag_3}, ...]]]`: Tags a module from Le Tracker
  - `tag {lecture_name} [/mod {module_code}] /tags {tag_1}[, {tag_2}[, {tag_3}, ...]]]`: Tags a lecture from 
    a module 
  - `tag {video_name} [/lec {lecture_name}] [/mod {module_code}] /tags {tag_1}[, {tag_2}[, {tag_3}, ...]]]`: 
    Tags a video from a lecture
  - `untag {module_code} /tags {tag_1}[, {tag_2}[, {tag_3}, ...]]]`: Removes specified tags from a module 
    from Le Tracker
  - `untag {lecture_name} [/mod {module_code}] /tags {tag_1}[, {tag_2}[, {tag_3}, ...]]]`: Removes the 
    specified tags from a lecture 
  - `untag {video_name} [/lec {lecture_name}] [/mod {module_code}] /tags {tag_1}[, {tag_2}[, {tag_3}, ...]]]`:
       Removes the specified tags of a video
  
Refer to the [Features](#features) below for details of each command.

---

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

- Words encapsulated in `{}` are the parameters to be supplied by the user.<br>
  e.g. in `add {module_code}`, `{module_code}` is a parameter which can be used as `add CS2040`.

- Items in square brackets are optional.<br>
  e.g. `add {module_code} [/name {module_name}]` can be used as `add CS2040 /name Data Structures and Algorithms` or as `add CS2040`.

- Named parameters can be specified in any order as long as it is after all unnamed parameters (if any).<br>
  e.g. `edit {module_code} /code {updated_code} /name {updated_name}` can be used as `edit CS2040 /code CS2040S /name DSAG` or as `edit CS2040 /name DSAG /code CS2040S`.

- If a named parameter is expected only once in the command but the user specified it multiple times, only the last occurrence of the parameter will be taken.<br>
  e.g. `add {module_code} [/name {module_name}]` if used as `add CS2040 /name Data Structures and Algorithms /name DSAG`, `DSAG` will be used as the value of the `/name` parameter.

- Extraneous parameters will be ignored.<br>
  e.g. `add {module_code} /name {module_name}` if used as `add CS2040 /name DSAG /foo bar`, the `/foo` parameter is ignored.

</div>

### Navigate to the Root Context

Sets the current context to the root context

Format: `nav`

### Navigate Relatively

Navigates relative to the current context to a module or lecture context

Format: `nav {module_code / lecture_name}`

- `module_code` has to belong to an existing module that is a child of the current context
- `lecture_name` has to belong to an existing lecture that is a child of the current context

### Navigate Directly

Navigates directly to the specified module or lecture context

Format: `nav /mod {module_code / lecture_name} [/lec {lecture_name}]`

- `module_code` has to belong to an existing module
- `lecture_name` has to belong to an existing lecture

### Navigate Backwards

Navigates to the parent context of the current context

Format: `navb`

### Add a Module

Adds a module to Le Tracker.

Format: `add {module_code} [/name {module_name}]`

- `module_code` must be unique among the module codes of the modules in Le Tracker
- `module_code` must be a valid module code
- `module_name` must be a valid module name

Examples:

- `add CS2040 /name Data Structures and Algorithms`

### Add a Lecture

Adds a lecture to a module.

Format: `add {lecture_name} [/mod {module_code}]`

- `lecture_name` must be a valid lecture name
- `lecture_name` must be unique among the names of the lectures belonging to the module specified in `module_code`
- `module_code` must belong to an existing module
- `module_code` if not specified, defaults to the module code of the module in the current context (if any)

Examples:

- `add Lecture 01 Introduction /module CS2040`

### Add a Video

Adds a video to a lecture.

Format: `add {video_name} [/mod {module_code}] [/lec {lecture_name}]`

- `video_name` must be a valid video name
- `video_name` must be unique among the names of the videos belonging to the lecture specified in `lecture_name`
- `module_code` must belong to an existing module
- `module_code` if not specified, defaults to the module code of the module in the current context (if any)
- `lecture_name` must belong to a lecture that exist within the module specified in `module_code`
- `lecture_name` if not specified, defaults to the name of the lecture in the current context (if any)

Examples:

- `add-video /module CS2040 /lecture 1 /video lecture-01-part-1`

### Edit a Module

Edits the details of a module in Le Tracker.

Format: `edit {module_code} [/code {updated_code}] [/name {updated_name}]`

- `module_code` must belong to an existing module
- `updated_code` must be a valid module code
- `updated_code` must be unique among the module codes of the modules in Le Tracker
- `updated_name` must be a valid module name

Examples:

- `edit CS2040 /code CS2040S /name Data Structures and Algorithms`

### Edit a Lecture

Edits the details of a lecture.

Format: `edit {lecture_name} [/mod {module_code}] [/name {updated_name}]`

- `lecture_name` must belong to a lecture that exist within the module specified in `module_code`
- `module_code` must belong to an existing module
- `module_code` if not specified, defaults to the module code of the module in the current context (if any)
- `updated_name` must be a valid lecture name
- `updated_name` must be unique among the names of the lectures belonging to the module specified in `module_code`

Examples:

- `edit Lecture 01 /mod CS2040S /name Lecture 01 Introduction`

### Edit a Video

Edits the details of a video

Format: `edit {video_name} [/mod {module_code}] [/lec {lecture_name}] [/name {updated_name}]`

- `video_name` must belong to a video that exist within the lecture specified in `lecture_name`
- `module_code` must belong to an existing module
- `module_code` if not specified, defaults to the module code of the module in the current context (if any)
- `lecture_name` must belong to a lecture that exist within the module specified in `module_code`
- `lecture_name` if not specified, defaults to the name of the lecture in the current context (if any)
- `updated_name` must be a valid video name
- `updated_name` must be unique among the names of the videos belonging to the lecture specified in `lecture_name`

Examples:

- `edit Video 01 /mod CS2040S /lec Lecture 03 Sorting /name Video 01 Analysis`

### Mark/Unmark a Video

Marks/Unmarks a video as watched/unwatched in a lecture of its specified module

Format: `mark /module {module_name} /lecture {lecture_index} /video {video_name}`

Format: `unmark /module {module_name} /lecture {lecture_index} /video {video_name}`

Examples:

- `mark /module CS2040 /lecture 1 /video lecture_01-part-1`
- `unmark /module CS2040 /lecture 1 /video lecture_01-part-1`

### Delete a Module

Deletes the specified module and all its embodied content from the application

Format: `delete-module CS2040`

- Deletes the module of the specified `module_code`
- If the module does not exist, nothing happens

Examples:

- `delete-module CS2040`

### Delete a Lecture

Deletes the specified lecture from the specified module

Format: `delete-lecture /module {module_code} /lecture {lecture_id}`

- Deletes the lecture of the specified `lecture_id` from the specified `module_code`
- The `lecture_id` **must be a positive integer** 1, 2, 3, ...

Examples:

- `delete-lecture CS2040 /lecture 1` deletes the 1st lecture in the results of the `list /module CS2040` command

### Delete a Video

Deletes the specified video from the specified lecture from the specified module

Format: `delete-video /module {module_code} /lecture {lecture_id} /video {video_id}`

- Deletes the video of the specified `video_id` from the specified `lecture_id` of the specified `module_code`
- `video_id` refers to the index number shown when listing the videos of the specified lecture using the `lecture_id` in the specified module using the `module_code`
- the `video_id` **must be a positive integer** 1, 2, 3, ...

Examples:

- `delete-video /module CS2040 /lecture 1 /video 3` deletes the 3rd video in the results of the `list /module CS2040 /lecture 1` command

### Tag a module

Tag a specified module from the current list of modules in Le Tracker with descriptions

Format: `tag {module_code} /tags {tag_1}[, {tag_2}[, {tag_3}, ...]]]`

- `module_code` must belong to an existing module
- `tag_1, tag_2, ...` must be of correct format

Example:
- `tag EG2310 /tags fun, hard` tags the module `EG2310` with the tags `fun` and `hard`

### Tag a lecture

Tag a specified lecture with descriptions

Format: `tag {lecture_name} [/mod {module_code}] /tags {tag_1}[, {tag_2}[, {tag_3}, ...]]]`

- `module_code` must belong to an existing module
- `module_code` if not specified, defaults to the module code of the module in the current context (if any)
- `lecture_name` must belong to an existing lecture in the specified module
- `tag_1, tag_2, ...` must be of correct format

Examples:
- `tag Lecture_1 /mod CS2040 /tags Yay` tags the lecture `Lecture_1` in the module `CS2040` with the tag 
  `Yay`

### Tag a video

Tag a specified video with descriptions

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

Remove specified tags from a specified module in the current list of modules in Le Tracker

Format: `untag {module_code} /tags {tag_1}[, {tag_2}[, {tag_3}, ...]]]`

- `module_code` must belong to an existing module
- `tag_1, tag_2, ...` must belong to existing tags of the specified module

Example:
- `untag EG2310 /tags fun, hard` removes the tags `fun` and `hard` from the module `EG2310`

### Untag a lecture

Untag a specified lecture from a specified module with a description

Format: `untag {lecture_name} [/mod {module_code}] /tags {tag_1}[, {tag_2}[, {tag_3}, ...]]]`

- `module_code` must belong to an existing module
- `module_code` if not specified, defaults to the module code of the module in the current context (if any)
- `lecture_name` must belong to an existing lecture in the specified module
- `tag_1, tag_2, ...` must belong to existing tags of the specified lecture

Examples:
- `untag Lecture_1 /mod CS2040 /tags Yay` removes the tag `Yay` from the lecture `Lecture_1` in the module `CS2040`

### Untag a video

Remove specified tags from video

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

### Progress

Displays lecture progress for a specified module

Format: `progress {module_code}`

- Displays progress of a specified `module_code`

Example: `progress CS2040S` lists progress for the module CS2040S

### List Modules

Lists all modules

Format: `list`

### List Lectures of Modules

Lists all lectures belonging to a specified module code

Format: `list [/mod {module_code}]`

- `module_code` must belong to an existing module
- `module_code` if not specified, defaults to the module code of the module in the current context (if any)

Examples: `list /mod CS2040S` lists lectures belonging to CS2040S

### List Videos of Lectures

Lists all videos belonging to a specified lecture code of a specified module code

Format: `list [/mod {module_code} /lec {lecture_name}]`

- `module_code` must belong to an existing module
- `module_code` if not specified, defaults to the module code of the module in the current context (if any)
- `lecture_name` must belong to a lecture that exist within the module specified in `module_code`
- `lecture_name` if not specified, defaults to the name of the lecture in the current context (if any)

Examples: `list /mod CS2040 /lect wk1` lists videos belongs to lecture wk1 of module CS2040S

### Saving the data

Le Tracker data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

Le Tracker data are saved as a JSON file `[JAR file location]/data/letracker.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, Le Tracker will discard all data and start with an empty data file at the next run.
</div>

---

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous Le Tracker home folder.

---

<!-- TODO: Update this after user guide is finalised -->
<!-- ## Command summary

| Action               | Format, Examples                                                                                                                                         |
| -------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Add a Module**     | `add-module /code {module_code} [/name {module_name}]` <br> e.g., `add-module /code CS2040 /name Data Structures & Algorithms`                           |
| **Add a Lecture**    | `add-lecture /module {module_code}` <br> e.g., `add-lecture /module CS2040`                                                                              |
| **Add a Video**      | `add-video /module {module_name} /lecture {lecture_index} /video {video_name}` <br> e.g., `add-video /module CS2040 /lecture 1 /video lecture-01-part-1` |
| **Tag a Lecture**    | `tag /module {module_code} /lecture {lecture_id} /description {tag_description}` <br> e.g, `tag /module CS2040 /lecture 1 /description Boohoo`|
| **Delete a Tag**     | `untag /module {module_code} /lecture {lecture_id} /tag {tag_id}` <br> e.g,  `untag /module CS2040 /lecture 1 /tag 1` | -->
