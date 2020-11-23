package de.azizothman.animatedbar;

import com.codename1.ui.FontImage;
import com.codename1.ui.Form;

/**
 *
 * @author Aziz
 */
public class AnimatedTab {

    /**
     * The text which will be shown on the Tab
     */
    private String title;

    /**
     * The Material Icon of the Tab
     */
    private char icon;

    /**
     * The Form which will be opened as the tab pressed
     */
    private Form form;

    /**
     * Constructor
     */
    public AnimatedTab() {
        this("", FontImage.MATERIAL_TAB);
    }

    /**
     * Constructor
     *
     * @param title the Text of the Tab
     * @param icon the material icon from FontInmage class
     */
    public AnimatedTab(String title, char icon) {
        this(title, icon, null);
    }

    /**
     * Constructor
     *
     * @param title
     * @param icon
     * @param form
     */
    public AnimatedTab(String title, char icon, Form form) {
        this.title = title;
        this.icon = icon;
        this.form = form;
    }

    /**
     *
     * @return the title of the tab
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the title of the tab
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * 
     * @return the icon of the tab
     */
    public char getIcon() {
        return icon;
    }
    /**
     * set the material icon of the tab
     * @param icon 
     */
    public void setIcon(char icon) {
        this.icon = icon;
    }
    /**
     * 
     * @return the form which will be showen
     */
    public Form getForm() {
        return form;
    }
    /**
     * set the connected form which will ne showen as the tab pressed
     * @param form 
     */
    public void setForm(Form form) {
        this.form = form;
    }

}
