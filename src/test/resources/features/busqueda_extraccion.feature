#language: es

Característica: Como usario de la pagina Airbnb quiero realizar una busqueda para extraer la información del primer resultado en un excel

  @BusquedaFiltrado
    Escenario: Busqueda y filtrado de alojamiento
    Dado que el usuario se encuentra en la pagina principal de Airbnb
    Cuando el usuario ingresa el destino "Sopetrán, Antioquia" con la cantidad de días 15 para la estadia
    Y el usuario filtra por  adultos 2, niños 1 y mascotas 1
    Y el usuario establece el precio maximo por noche 86771496
    Y el usuario selecciona las comodidades "Wifi", "Cocina" y "Piscina"
    Y el usuario visualiza la lista de alojamientos disponibles
    Cuando que el usuario ve la lista de alojamientos da click en el primer resultado
    Entonces el ve los datos del alojamiento y extrae la información en un archivo excel "datosDelPrimerAlojamiento"







