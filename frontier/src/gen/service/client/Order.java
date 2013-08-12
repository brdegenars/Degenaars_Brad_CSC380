
package gen.service.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for order complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="order">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="apps" type="{http://localhost/RestaurantWebService}app" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="entrees" type="{http://localhost/RestaurantWebService}entree" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="restaurantName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "order", propOrder = {
    "apps",
    "entrees",
    "restaurantName"
})
public class Order {

    @XmlElement(nillable = true)
    protected List<App> apps;
    @XmlElement(nillable = true)
    protected List<Entree> entrees;
    protected String restaurantName;

    /**
     * Gets the value of the apps property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the apps property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApps().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link App }
     * 
     * 
     */
    public List<App> getApps() {
        if (apps == null) {
            apps = new ArrayList<App>();
        }
        return this.apps;
    }

    /**
     * Gets the value of the entrees property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entrees property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntrees().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Entree }
     * 
     * 
     */
    public List<Entree> getEntrees() {
        if (entrees == null) {
            entrees = new ArrayList<Entree>();
        }
        return this.entrees;
    }

    /**
     * Gets the value of the restaurantName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRestaurantName() {
        return restaurantName;
    }

    /**
     * Sets the value of the restaurantName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRestaurantName(String value) {
        this.restaurantName = value;
    }

}
