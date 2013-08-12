
package gen.service.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for menu complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="menu">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="availableApps" type="{http://localhost/RestaurantWebService}app" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="availableEntrees" type="{http://localhost/RestaurantWebService}entree" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "menu", propOrder = {
    "availableApps",
    "availableEntrees"
})
public class Menu {

    @XmlElement(nillable = true)
    protected List<App> availableApps;
    @XmlElement(nillable = true)
    protected List<Entree> availableEntrees;

    /**
     * Gets the value of the availableApps property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the availableApps property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAvailableApps().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link App }
     * 
     * 
     */
    public List<App> getAvailableApps() {
        if (availableApps == null) {
            availableApps = new ArrayList<App>();
        }
        return this.availableApps;
    }

    /**
     * Gets the value of the availableEntrees property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the availableEntrees property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAvailableEntrees().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Entree }
     * 
     * 
     */
    public List<Entree> getAvailableEntrees() {
        if (availableEntrees == null) {
            availableEntrees = new ArrayList<Entree>();
        }
        return this.availableEntrees;
    }

}
