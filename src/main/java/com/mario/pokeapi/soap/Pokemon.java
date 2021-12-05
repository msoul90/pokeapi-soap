//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.12.04 a las 06:03:06 PM CST 
//


package com.mario.pokeapi.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para pokemon complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="pokemon">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="abilities" type="{http://www.mario.com/pokeapi/soap}abilities"/>
 *         &lt;element name="base_experience" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="held_items" type="{http://www.mario.com/pokeapi/soap}held_items"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="location_area_encounters" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pokemon", propOrder = {
    "abilities",
    "baseExperience",
    "heldItems",
    "id",
    "name",
    "locationAreaEncounters"
})
public class Pokemon {

    @XmlElement(required = true)
    protected Abilities abilities;
    @XmlElement(name = "base_experience")
    protected int baseExperience;
    @XmlElement(name = "held_items", required = true)
    protected HeldItems heldItems;
    protected int id;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(name = "location_area_encounters", required = true)
    protected String locationAreaEncounters;

    /**
     * Obtiene el valor de la propiedad abilities.
     * 
     * @return
     *     possible object is
     *     {@link Abilities }
     *     
     */
    public Abilities getAbilities() {
        return abilities;
    }

    /**
     * Define el valor de la propiedad abilities.
     * 
     * @param value
     *     allowed object is
     *     {@link Abilities }
     *     
     */
    public void setAbilities(Abilities value) {
        this.abilities = value;
    }

    /**
     * Obtiene el valor de la propiedad baseExperience.
     * 
     */
    public int getBaseExperience() {
        return baseExperience;
    }

    /**
     * Define el valor de la propiedad baseExperience.
     * 
     */
    public void setBaseExperience(int value) {
        this.baseExperience = value;
    }

    /**
     * Obtiene el valor de la propiedad heldItems.
     * 
     * @return
     *     possible object is
     *     {@link HeldItems }
     *     
     */
    public HeldItems getHeldItems() {
        return heldItems;
    }

    /**
     * Define el valor de la propiedad heldItems.
     * 
     * @param value
     *     allowed object is
     *     {@link HeldItems }
     *     
     */
    public void setHeldItems(HeldItems value) {
        this.heldItems = value;
    }

    /**
     * Obtiene el valor de la propiedad id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define el valor de la propiedad name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtiene el valor de la propiedad locationAreaEncounters.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocationAreaEncounters() {
        return locationAreaEncounters;
    }

    /**
     * Define el valor de la propiedad locationAreaEncounters.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocationAreaEncounters(String value) {
        this.locationAreaEncounters = value;
    }

}
