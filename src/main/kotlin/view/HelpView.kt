package view

import javafx.scene.control.Accordion
import javafx.scene.control.TextArea
import javafx.scene.layout.VBox
import tornadofx.*

class HelpView : View("Help") {
    override val root = vbox {
        prefHeight = 700.0
        accordion {
            fold("Menu", Accordion()) {
                fold("File", TextArea()) {
                    isEditable = false
                    text = """
                    "File" is a menu option containing basic operations that allow you to interact with the file system.
                    1) Create new (Ctrl + N) - suboption to create new file. Firstly you should specify new file name, then choose a directory to save th file;
                    2) Open (Ctrl + O) - suboption to open new file;
                    3) Save (Ctrl + S) - suboption to save changes in current file. You may be asked to specify filename if there isn't current file to save;
                    4) Save As (Ctrl + Shift + S) - suboption to save content to specified file. Before specifying directory you will be asked to type filename;
                    5) Exit - suboption which will close application.
                """.trimIndent()
                }
                fold("Edit", TextArea()) {
                    isEditable = false
                    text = """
                    "Edit" is a menu option containing basic operations for interacting with text in the input text area.
                     1) Undo (Ctrl + Z) - suboption to undo last action;
                     2) Redo (Ctrl + Shift + Z) - suboption to redo undoned action;
                     3) Cut (Ctrl + X) - cut selected part of text (it will be placed in clipboard);
                     4) Copy (Ctrl + C) - copy selected part of text and stores it to clipboard;
                     5) Paste (Ctrl + V) - paste text from clipboard to text area (starting from text pointer);
                     6) Remove (Ctrl + D) - suboption to delete selected part of text;
                     7) Select All (Ctrl + A) - suboption to select all the text in text area.
                """.trimIndent()
                }
                fold("Text", TextArea()) {
                    isEditable = false
                    text = """
                    "Text" menu contains "Problem", "Grammar", "Grammar classification", "Analysis method",
                    "Diagnostic", "Example", "Literature sources" and "Code sources" suboptions.
                """.trimIndent()
                }
                fold("Run", TextArea()) {
                    isEditable = false
                    text = """
                    "Run" option will start entered text handling.
                """.trimIndent()
                }
                fold("Help", TextArea()) {
                    isEditable = false
                    text = """
                    You are now in Help option.
                """.trimIndent()
                }
                fold("About", TextArea()) {
                    isEditable = false
                    text = """
                    "About" - contains information about application and it's author.
                """.trimIndent()
                }
            }
            fold("Instrumental pane", VBox()) {
                textarea {
                    isEditable = false
                    text = """
                    Instrumental pane contains some handy options from "File" and "Edit" menus.
                    
                    1) Create new (Ctrl + N) - creates new file. Firstly you should specify new file name, 
                        then choose a directory to save th file;
                    2) Open (Ctrl + O) - opens new file;
                    3) Save (Ctrl + S) - saves changes in current file. 
                        You may be asked to specify filename if there isn't current file to save;
                    4) Undo (Ctrl + Z) - undoes last action;
                    5) Redo (Ctrl + Shift + Z) - redoes undoned action;
                    6) Cut (Ctrl + X) - cuts selected part of text (it will be placed in clipboard);
                    7) Copy (Ctrl + C) - copies selected part of text and stores it to clipboard;
                    8) Paste (Ctrl + V) - pastes text from clipboard to text area (starting from text pointer).

                """.trimIndent()
                }
            }
        }
    }
}
