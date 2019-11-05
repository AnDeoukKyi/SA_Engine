package com.example.an.sa_engine.SA_ENGINE.System.Option;

public class SA_FLAG {

    public static final int USER_VIEW_TYPE_PORTRAIT = 0x00000000;
    public static final int USER_VIEW_TYPE_LANDSCAPE = 0x00000001;

    public static final int USER_VIEW_WINDOWSIZE_YES = 0x00100000;
    public static final int USER_VIEW_WINDOWSIZE_NO = 0x00100001;




    public static final int USER_DEBUG_MODE_YES = 0x01000000;
    public static final int USER_DEBUG_MODE_NO = 0x01000001;

    public static final int USER_DEBUG_LOG_CREATEOBJ_YES = 0x01100000;
    public static final int USER_DEBUG_LOG_CREATEOBJ_NO = 0x01100001;


    //draw
    public static final int ENGINE_DRAW_CREATE_SPRITE = 0x10000000;
    public static final int ENGINE_DRAW_CREATE_RECT = 0x10100001;
    public static final int ENGINE_DRAW_CREATE_CIRCLE = 0x10100002;
    public static final int ENGINE_DRAW_CREATE_ROUNDRECT = 0x10200003;
    public static final int ENGINE_DRAW_CREATE_LINE = 0x10300004;
    public static final int ENGINE_DRAW_CREATE_TEXT = 0x10400005;




    public static final int ENGINE_DRAW_OPTION_FILLEDGE = 0x10500000;
    public static final int ENGINE_DRAW_OPTION_EDGE = 0x10500001;
    public static final int ENGINE_DRAW_OPTION_FILL = 0x10500002;

    public static final int ENGINE_DRAW_OPTION_ALIGN_TOP = 0x10500000;
    public static final int ENGINE_DRAW_OPTION_ALIGN_MIDDLE = 0x10500001;
    public static final int ENGINE_DRAW_OPTION_ALIGN_BOTTOM = 0x10500002;
    public static final int ENGINE_DRAW_OPTION_ALIGN_LEFT = 0x10500003;
    public static final int ENGINE_DRAW_OPTION_ALIGN_RIGHT = 0x10500004;
    public static final int ENGINE_DRAW_OPTION_ALIGN_CENTER = 0x10500005;

    public static final int ENGINE_DRAW_OPTION_POS_POINT2POINT = 0x10510000;
    public static final int ENGINE_DRAW_OPTION_POS_LENGTH = 0x10510001;


    public static final int ENGINE_DRAW_OPTION_RELATIVE = 0x10400002;
    public static final int ENGINE_DRAW_OPTION_CAMERA = 0x10400003;


    //mask
    public static final int ENGINE_MASK_CREATE_RECT = 0x11000000;
    public static final int ENGINE_MASK_CREATE_CIRCLE = 0x11000001;
    public static final int ENGINE_MASK_CREATE_AUTO = 0x11000002;
    public static final int ENGINE_MASK_CREATE_CUSTOM = 0x11000003;



    public static final int ENGINE_CLICK_DOWN = 0x12000000;
    public static final int ENGINE_CLICK_UP = 0x12000001;
    public static final int ENGINE_CLICK_DRAG = 0x12000002;



    public static final int ENGINE_OBJECT_SCROLL_HORIZONTAL = 0x13000000;
    public static final int ENGINE_OBJECT_SCROLL_VERTICAL = 0x12000001;



    public static final int PARAM_POS_CENTER = 0x21000002;
}
