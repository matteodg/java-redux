/* file name  : src/main/java/com/mati365/calc/ui/AppMenu.java
 * authors    : Mateusz Bagiński (cziken58@gmail.com)
 * created    : czw 22 mar 21:04:22 2018
 * copyright  : MIT
 *
 * modifications:
 *
 */
package com.mati365.calc.ui;

import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.validation.constraints.NotNull;

import com.mati365.calc.utils.Resources;
import com.mati365.calc.utils.AppDestroyer;

import com.mati365.calc.logic.SheetLogic;
import com.mati365.calc.logic.Logicable;

/** 
 * MenuItem with translation 
 * 
 * @author Mateusz Bagiński (cziken58@gmail.com)
 */
class TranslatedMenuItem extends JMenuItem {
    private static final long serialVersionUID = 1L;

    public TranslatedMenuItem(@NotNull String key, ActionListener listener) {
        super(Resources.Translations.getString(key));
        if (listener != null)
            addActionListener(listener);
    }
}

/** 
 * Main App menu 
 * 
 * @author Mateusz Bagiński (cziken58@gmail.com)
 */
public class AppMenu extends Logicable<SheetLogic> {
    private JMenuBar menu = null;

    public AppMenu(@NotNull SheetLogic logic) {
        super(logic);
        menu = new JMenuBar(); 

        menu.add(this.getFileMenu());
        menu.add(this.getEditMenu());
        menu.add(this.getInfoMenu());
    }

    public JMenuBar getMenu() { return this.menu; }
    
    /** 
     * Create file menu entry and attach action listeners 
     * 
     * @return 
     */
    public JMenu getFileMenu() {
        JMenu menu = new JMenu(Resources.Translations.getString("file"));
        
        JMenuItem open = new TranslatedMenuItem("open", (MouseEvent) -> logic.loadState());
        menu.add(open);

        JMenuItem save = new TranslatedMenuItem("save", (MouseEvent) -> logic.exportState());
        menu.add(save);
        
        JMenuItem exit = new TranslatedMenuItem("exit", (e) -> AppDestroyer.tryKillApp(logic));
        menu.addSeparator();
        menu.add(exit);

        return menu;
    }

    /** 
     * Create edit menu entry and attach action listeners 
     * 
     * @return 
     */
    public JMenu getEditMenu() {
        JMenu menu = new JMenu(Resources.Translations.getString("edit"));

        JMenuItem undo = new TranslatedMenuItem("undo", (MouseEvent) -> logic.undo());
        menu.add(undo);

        JMenuItem redo = new TranslatedMenuItem("redo", (MouseEvent) -> logic.redo());
        menu.add(redo);
        
        return menu;
    }

    /** 
     * Create info menu entry and attach action listeners 
     * 
     * @return 
     */
    public JMenu getInfoMenu() {
        JMenu menu = new JMenu(Resources.Translations.getString("info"));
        
        JMenuItem help = new TranslatedMenuItem("help", null);
        menu.add(help);

        JMenuItem author = new TranslatedMenuItem("author", null);
        menu.add(author);
        
        return menu;
    }
}
