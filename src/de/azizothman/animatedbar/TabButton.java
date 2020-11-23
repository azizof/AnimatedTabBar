package de.azizothman.animatedbar;

import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.UITimer;

/**
 *
 * @author Aziz
 */
class TabButton extends Button {

    /**
     * This variable used in the animation help to rotate the Button
     */
    private int rotate = 0;

    /**
     * Constructor
     *
     * @param tab
     */
    public TabButton(AnimatedTab tab) {
        initGUI(tab);
    }

    /**
     * Initialize the GUI of the Button
     *
     * @param tab
     */
    private void initGUI(AnimatedTab tab) {
        // set the Title if not null
        if (tab.getTitle() != null && !tab.getTitle().trim().isEmpty()) {
            setText(tab.getTitle());
            setTextPosition(Button.BOTTOM);
        }
        // Set the icon of the Button
        FontImage.setMaterialIcon(this, tab.getIcon(), 5);
    }

    /**
     * Animate the Button
     *
     * @return
     */
    @Override
    public boolean animate() {
        UITimer timer = new UITimer(() -> {
            if (rotate <= 360) {
                Image image = getIcon();
                setIcon(image.rotate(rotate));
                rotate += 5;
            }
        });
        timer.schedule(30, true, getComponentForm());
        if (rotate >= 360) {
            timer.cancel();
            rotate = 0;
            return false;
        }
        return false;
    }

    /**
     * Set the Style of the Button used in the unselected style used as helper
     * on the AnimatedTabBar class
     *
     * @param style
     */
    public void setStyle(Style style) {
        setUnselectedStyle(style);
        setSelectedStyle(style);
        setPressedStyle(style);
        setDisabledStyle(style);

    }
}
