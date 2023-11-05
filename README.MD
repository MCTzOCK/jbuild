# Java Build Tools

A simple CLI tool to build plain java projects
without any build tools like maven or gradle.

There is currently no support for dependencies
and only executable jars are supported.

---

### Usage
This is a CLI tool, so you have to use the command line to use it.
You can download the latest version from the [releases](https://github.com/MCTzOCK/jbuild/releases) page.

**Example**:

```shell
java -jar jb.jar -s my_project_src -d my_project.jar -m com.bensiebert.myproject.Main
```

| Argument | Description |
| --- | --- |
| -s | The source directory of your project. |
| -d | The destination of the jar file. |
| -m | The main class of your project. |

The tool was made by [Ben Siebert](https://ben-siebert.com).

### License
This project is licensed with the following conditions:
- You are allowed to use this project for private and commercial purposes.
- You are allowed to modify this project.
- You are allowed to distribute this project, only if you give credits to the original creator (Ben Siebert) and have made significant changes to the project.
- You are not allowed to sell modified versions this project.
- If you redistribute this project in any way, you have to make the source code of the project available and have to include this license.