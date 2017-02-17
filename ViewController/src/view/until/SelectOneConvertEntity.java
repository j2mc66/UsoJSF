package view.until;

import java.util.List;

import javax.el.ValueExpression;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


/**
 * permite convertir de un valor de f:selectItems a una entidad para ello la
 * entidad deve tener el atributo id
 *
 *
 */
@FacesConverter(value = "selectOneConvertEntity")
public class SelectOneConvertEntity implements Converter {
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
            List<UIComponent> hijos = component.getChildren();
            UISelectItems items = null;
            for (UIComponent uiComponent : hijos) {
                    if (uiComponent instanceof UISelectItems) {
                            items = (UISelectItems) uiComponent;
                            break;
                    }
            }
            if (items != null) {
                    ValueExpression valueExp = items.getValueExpression("value");
                    List<Object> listaValores = (List<Object>) valueExp
                                    .getValue(FacesContext.getCurrentInstance().getELContext());
                    if (null != listaValores) {
                            for (Object object : listaValores) {
                                    if (object.toString().equals(value)) {
                                            return object;
                                    }
                            }
                    }
            }
            return null;
    }
        
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
            return (value == null ? null : value.toString());
    }
}


