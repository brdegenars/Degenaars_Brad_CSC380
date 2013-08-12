
package gen.service.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}Apps"/>
 *         &lt;element ref="{}Entrees"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "apps",
    "entrees"
})
@XmlRootElement(name = "Menu")
public class Menu {

    @XmlElement(name = "Apps", required = true)
    protected Apps apps;
    @XmlElement(name = "Entrees", required = true)
    protected Entrees entrees;

    /**
     * Gets the value of the apps property.
     * 
     * @return
     *     possible object is
     *     {@link Apps }
     *     
     */
    public Apps getApps() {
        return apps;
    }

    /**
     * Sets the value of the apps property.
     * 
     * @param value
     *     allowed object is
     *     {@link Apps }
     *     
     */
    public void setApps(Apps value) {
        this.apps = value;
    }

    /**
     * Gets the value of the entrees property.
     * 
     * @return
     *     possible object is
     *     {@link Entrees }
     *     
     */
    public Entrees getEntrees() {
        return entrees;
    }

    /**
     * Sets the value of the entrees property.
     * 
     * @param value
     *     allowed object is
     *     {@link Entrees }
     *     
     */
    public void setEntrees(Entrees value) {
        this.entrees = value;
    }

}
