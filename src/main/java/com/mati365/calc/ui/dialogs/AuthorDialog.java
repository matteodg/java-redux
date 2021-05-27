/* file name  : src/main/java/com/mati365/calc/ui/dialogs/AuthorDialog.java
 * authors    : Mateusz Bagiński (cziken58@gmail.com)
 * created    : ptk 23 mar 22:46:41 2018
 * copyright  : MIT
 *
 * modifications:
 *
 */
package com.mati365.calc.ui.dialogs;

import javax.validation.constraints.NotNull;
import javax.swing.JComponent;

import com.mati365.calc.utils.Resources;

/** 
 * @author Mateusz Bagiński (cziken58@gmail.com)
 */
public class AuthorDialog extends MessageDialog {
    private static final long serialVersionUID = 1l;

    public AuthorDialog(@NotNull JComponent parent) {
        super(
                parent, 
                Resources.Translations.getString("author_message"));
    }
}
