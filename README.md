# pokeapi-soap

Web Service SOAP para el consumo de la API REST [**pokeapi**](https://pokeapi.co/).

## Requerimientos

- JDK 8:
  - [**Prebuilt OpenJDK Binaries**](https://adoptium.net/?variant=openjdk8&jvmVariant=hotspot) 

## BD

- URL BD Admin: <http://localhost:8080/h2-ui/login.jsp>
- name:h2:mem:pokeapi
- username:pika
- password:chu

## Ejecución

`mvn8 clean compile spring-boot:run -f pom.xml`

### mvn8

Es necesario compilar usando JDK8 por la dependencia de las librerías de SOAP. Para esto se puede definir el path del JDK8 en un archivo especifico de mvn ubicado en el path: apache-maven-3.8.4\bin

```bash
setlocal
set "JAVA_HOME=C:\Program Files\Eclipse Adoptium\jdk-8.0.312.7-hotspot
set "path=%JAVA_HOME%;%path%"
```

## WSDL

`http://localhost:8080/ws/pokemon.wsdl`

### Métodos

Todos los métodos reciben como parámetro el nombre/id del Pokémon a consultar.

- getPokemon: Obtiene todos los datos del Pokémon consultado.
- getPokemonAbilities:  Obtiene las habilidades del Pokémon consultado.
- getPokemonId: Obtiene el Id del Pokémon consultado.
- getPokemonBaseExperience: Obtiene la experiencia base del Pokémon consultado.
- getPokemonLocationAreaEncounters: Obtiene el enlace de las áreas de aparición del Pokémon consultado.
- getPokemonName: Obtiene el nombre del Pokémon consultado.
- getPokemonHeldItems: Obtiene los objetos del Pokémon consultado. *1

NOTA:

- 1: Existe un issue al consultar el servicio rest de pokeapi que siempre obtiene un array vacío de los objetos del Pokémon.

### Ejemplo Request OK (SOAPUI)

```XML
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:soap="http://www.mario.com/pokeapi/soap">
   <soapenv:Header/>
   <soapenv:Body>
      <soap:getPokemonRequest>
         <soap:name>1</soap:name>
      </soap:getPokemonRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

### Ejemplo Response OK (SOAPUI)

```XML
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns2:getPokemonResponse xmlns:ns2="http://www.mario.com/pokeapi/soap">
         <ns2:pokemon>
            <ns2:abilities>
               <ns2:pokemonAbility>
                  <ns2:ability>
                     <ns2:name>overgrow</ns2:name>
                     <ns2:url>https://pokeapi.co/api/v2/ability/65/</ns2:url>
                  </ns2:ability>
                  <ns2:is_hidden>false</ns2:is_hidden>
                  <ns2:slot>1</ns2:slot>
               </ns2:pokemonAbility>
               <ns2:pokemonAbility>
                  <ns2:ability>
                     <ns2:name>chlorophyll</ns2:name>
                     <ns2:url>https://pokeapi.co/api/v2/ability/34/</ns2:url>
                  </ns2:ability>
                  <ns2:is_hidden>false</ns2:is_hidden>
                  <ns2:slot>3</ns2:slot>
               </ns2:pokemonAbility>
            </ns2:abilities>
            <ns2:base_experience>64</ns2:base_experience>
            <ns2:held_items/>
            <ns2:id>1</ns2:id>
            <ns2:name>bulbasaur</ns2:name>
            <ns2:location_area_encounters>https://pokeapi.co/api/v2/pokemon/1/encounters</ns2:location_area_encounters>
         </ns2:pokemon>
         <ns2:status>
            <ns2:code>OK</ns2:code>
            <ns2:message>POKEMON ENCONTRADO</ns2:message>
         </ns2:status>
      </ns2:getPokemonResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

### Ejemplo Request BAD (SOAPUI)

```XML
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:soap="http://www.mario.com/pokeapi/soap">
   <soapenv:Header/>
   <soapenv:Body>
      <soap:getPokemonRequest>
         <soap:name>-1</soap:name>
      </soap:getPokemonRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

### Ejemplo Response BAD (SOAPUI)

```XML
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns2:getPokemonResponse xmlns:ns2="http://www.mario.com/pokeapi/soap">
         <ns2:status>
            <ns2:code>ERROR</ns2:code>
            <ns2:message>POKEMON NO ENCONTRADO</ns2:message>
         </ns2:status>
      </ns2:getPokemonResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

## Docker hub

Para probarlo en un ambiente Linux puedes usar la siguiente imagen que tiene el JDK 8.

`docker pull msoul/pokeapi-soap:0.0.1`
