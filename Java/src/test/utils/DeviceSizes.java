package utils;

import org.openqa.selenium.Dimension;

public enum DeviceSizes {
    IPHONE_LANDSCAPE(new Dimension(640, 320)),
    IPHONE_PORTRAIT(new Dimension(320, 640)),
    IPAD(new Dimension(1024, 768)),
    STANDARD(new Dimension(1920, 1080));

    private final Dimension dimension;

    DeviceSizes(Dimension dimension){
        this.dimension = dimension;
    }

    public Dimension getDimension() {
        return dimension;
    }
}
