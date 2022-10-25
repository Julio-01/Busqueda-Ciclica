## Datos del integrante

* Nombre     -> Julio Cesar Torres Escobedo
* No. Cuenta -> 317336267

# Busqueda Binaria Ciclica

## Descripcion

Nuestro algoritmo consiste en encontrar un elemento de una secuencia ciclica, recibe dentro del codigo un archivo ".txt" llamado "ejemplares.txt". Dentro del archivo se divide de la siguiente manera:

```
4,5,6,7,8,9 -> Secuencia ciclica
5           -> Elemento a buscar

6,7,8,1,2,3 -> Secuencia ciclica
7           -> Elemento a buscar
```

Dentro del archivo podemos colocar varias secuencias, para cada secuencia el algoritmo imprimira su progreso.

## Entrada

Todas las entradas seran por medio del archivo "ejemplares.txt", dentro suponemos que cada secuencia es ciclica. El elemento a buscar puede o no exisitir. Cada secuencia tiene que estar separado por una linea. El elemento a buscar tiene que estar debajo de la secuencia donde buscaremos. Un ejemplo es el siguiente:

```
3,4,5,6,1,2 
2

23,34,37,40,43,12,18
12
```

La primera secuencia buscara el elemento "2" y la segunda buscara el elemento "12". No se aceptara una secuencia sin elemento a buscar o viceversa.

## Salida

Nuestra salida mostrara lo siguiente:

```
Secuencia Actual:   la secuencia con el que estamos
Iteracion #:        el # de iteracion
Indice izquierdo:   indice del pivote izquierdo y su elemento
Indice derecho:     indice del pivote derecho y su elemento
Mitad:              indice de la mitad
X[3] = 5 == 8? No   elemento del indice de la mitad y comparacion con el objeto a buscar
```


## Compilar

Para compilar nuestro programa, escribimos:

```sh
javac main.java
```

## Ejecucion

Para ejecutar nuestro programa, escribimos:

```sh
java main
```
