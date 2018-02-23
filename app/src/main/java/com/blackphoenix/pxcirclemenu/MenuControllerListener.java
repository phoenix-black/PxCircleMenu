package com.blackphoenix.pxcirclemenu;

interface MenuControllerListener {

    void onOpenAnimationStart();

    void onOpenAnimationEnd();

    void onCloseAnimationStart();

    void onCloseAnimationEnd();

    void onSelectAnimationStart(CircleMenuButton menuButton);

    void onSelectAnimationEnd(CircleMenuButton menuButton);

    void redrawView();
}
