//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.12.04 a las 06:03:06 PM CST 
//


package com.mario.pokeapi.soap;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para held_items complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="held_items">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pokemonHeldItem" type="{http://www.mario.com/pokeapi/soap}PokemonHeldItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "held_items", propOrder = {
    "pokemonHeldItem"
})
public class HeldItems {

    protected List<PokemonHeldItem> pokemonHeldItem;

    /**
     * Gets the value of the pokemonHeldItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pokemonHeldItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPokemonHeldItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PokemonHeldItem }
     * 
     * 
     */
    public List<PokemonHeldItem> getPokemonHeldItem() {
        if (pokemonHeldItem == null) {
            pokemonHeldItem = new ArrayList<PokemonHeldItem>();
        }
        return this.pokemonHeldItem;
    }

}
