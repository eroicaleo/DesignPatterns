
# Emacs mode

## Search and Find
* `Double Shift`: Search anywhere.
* `Alt+F7`: find all usage of a class, method and variable in the project.
* just type: speed search in the any tree view.

## Definition, Declaration and Documentation
* `Alt+Shift+G`：open any classes.
* `Ctrl+Q`: quick documentation.
* `Ctrl+Shift+I`: quick definition.
* `Alt+Period`, `Ctrl+Alt+G`: go to declaration.
* `Shift+F1`: Open definition in browser.

## Compile and Debug
* `Ctrl+F9`: Make the project.
* `Shift+F9`: Debug the code.
* `Shift+10`: run the code.

## Code Completion
* `Alt+Slash`: auto completion.
* `Shift+F6`: Rename classes, methods and variables across the whole project.
* `Ctrl+Shift+Space`: SmartType code completion, helps to find methods and
  variables that are suitable in the current context, by analyzing the expected
  type of the whole expression.
    * It can work with `new`. You just need to type `new` and type this.
    * In can work with type cast. You just need to type `()` and type this.
* `Ctrl+I`: Implement methods of the interface that the current class implements
  or of the abstract base class.
* `Alt+Insert`: generate getter and setter methods for any fields of your class.
* `Ctrl+Alt+T`: Surround code by `try/catch`, `if/else`, and `for/while` etc.
* `Ctrl+Alt+V`: Extract variable refactoring. Here is an example:
  ```java
  myEditorPane.setBorder(BoarderFactory.createEmptyBorder(5,5,5,5));
  // Hightlight the code inside braket and Refractor to
  Border emptyBorder = BoarderFactory.createEmptyBorder(5,5,5,5);
  myEditorPane.setBorder(emptyBorder);
  ```
* Live Templates: File | Setting | Live Templates `Ctrl+Alt+S`.

## Navigation

* `Alt+Home`: Navigation bar.
* `Ctrl+F12`: Navigate|File Structure, navigate in the currently edited file.
* `Alt+F1`: To quickly select the currently edited element (class, file, method
  or field) in any view.

## View and Windows

* `Alt+0`: show messages.
* `Alt+1`: project tree.
* `Alt+7`：file Structure, like `Ctrl+F12`, but in the left pane.
* `Shift+left-click` or `mid-click`: close tabs in the editor and the tool
  windows of IntelliJ.
* `Escape, Escape`: focus on editor.
* `Shift+Escapse`：focus on editor and close current tool window.
* `F12`: move focus from editor to last focused tool window.

## Edit
* `Ctrl+Alt+W`: extend selection, from word to line to paragraph.
* `Ctrl+Alt+/`: `/* */` comment code
* `Alt+;`: `//` comment code
