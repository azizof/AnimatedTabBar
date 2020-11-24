# AnimatedTabBar 
this is small lib which will allow you to create a tab bar with cool animations.


### Example
```java
        Form hi = new Form("Hi World", new BorderLayout());
        
        AnimatedTab tab1 = new AnimatedTab("Home ", FontImage.MATERIAL_HOME);
        AnimatedTab tab2 = new AnimatedTab("Profile", FontImage.MATERIAL_PERSON);
        AnimatedTab tab3 = new AnimatedTab("About", FontImage.MATERIAL_INFO);
        AnimatedTab tab4 = new AnimatedTab("FAQ", FontImage.MATERIAL_CONTACT_SUPPORT);
        AnimatedTabBar tabBar = new AnimatedTabBar(tab1, tab2, tab3, tab4);
        // Change text color while selected to red
        tabBar.setSelectedButtonColor(0xff0000);
        tabBar.setBarBGColor(0xffffff);
        // add the tab bar to the bottom of the form
        hi.add(BorderLayout.SOUTH, tabBar.buildContainer());
        hi.show();
