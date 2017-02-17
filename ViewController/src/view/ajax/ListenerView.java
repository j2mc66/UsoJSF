package view.ajax;

import javax.faces.bean.ManagedBean;


@ManagedBean(name="listenerView")
public class ListenerView {
     
    private String text;
 
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
     
    public void handleKeyEvent() {
        text = text.toUpperCase();
    }
}