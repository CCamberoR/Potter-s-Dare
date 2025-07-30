# Potter's Dare 🏰⚡

**Una simulación de duelos mágicos inspirada en el universo de Harry Potter**

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![BlueJ](https://img.shields.io/badge/BlueJ-0088CC?style=for-the-badge&logo=java&logoColor=white)
![Version](https://img.shields.io/badge/Version-1.0-green?style=for-the-badge)

## 📋 Tabla de Contenidos

- [Descripción del Proyecto](#-descripción-del-proyecto)
- [Características Principales](#-características-principales)
- [Arquitectura del Sistema](#-arquitectura-del-sistema)
- [Clases Principales](#-clases-principales)
- [Instalación y Configuración](#-instalación-y-configuración)
- [Cómo Ejecutar el Proyecto](#-cómo-ejecutar-el-proyecto)
- [Mecánicas del Juego](#-mecánicas-del-juego)
- [Estructura de Archivos](#-estructura-de-archivos)
- [Ejemplos de Uso](#-ejemplos-de-uso)
- [Testing](#-testing)
- [Autores](#-autores)
- [Licencia](#-licencia)

## 🎯 Descripción del Proyecto

**Potter's Dare (PD)** es un sistema de simulación de duelos mágicos desarrollado en Java que recrea competencias entre las casas de Hogwarts. El proyecto implementa conceptos avanzados de Programación Orientada a Objetos (POO), incluyendo patrones de diseño, herencia, polimorfismo, y estructuras de datos complejas.

### 🎮 Concepto del Juego

El sistema simula una competencia de duelos entre las tres casas principales de Hogwarts:
- **Gryffindor** 🦁
- **Hufflepuff** 🦡  
- **Slytherin** 🐍

Los personajes de cada casa compiten en turnos hasta que emerge un campeón o se alcanza el número máximo de turnos establecido.

## ✨ Características Principales

### 🔥 Sistema de Combate Avanzado
- **Duelos por turnos** con mecánicas de ataque y defensa
- **Varitas mágicas** con comportamientos específicos (Ofensivas/Defensivas)
- **Sistema de pociones** que modifican las habilidades de los personajes
- **Cálculo dinámico** de puntos de ataque y resistencia

### 🏛️ Gestión de Casas y Personajes
- **Tres casas** con personajes únicos y características distintivas
- **Sistema de reemplazo** de varitas mágicas automático
- **Gestión de mazmorras** para personajes eliminados
- **Ranking y estadísticas** de rendimiento

### 🎲 Mecánicas de Juego
- **Simulación automática** con registro detallado de eventos
- **Sistema de turnos** estructurado y balanceado
- **Múltiples tipos de personajes** (Ofensivos, Defensivos)
- **Efectos de pociones** temporales y permanentes

## 🏗️ Arquitectura del Sistema

El proyecto implementa varios patrones de diseño y principios de ingeniería de software:

### 📐 Patrones Implementados

1. **Singleton Pattern**: Clase `Hogwarts` - Una única instancia del colegio
2. **Strategy Pattern**: Varitas mágicas con diferentes comportamientos
3. **Decorator Pattern**: Sistema de pociones que envuelven personajes
4. **Template Method**: Estructura común para tipos de personajes

### 📊 Estructuras de Datos Utilizadas

- **HashMap**: Gestión eficiente de casas por nombre
- **ArrayList**: Listas de personajes y varitas de reemplazo
- **LinkedHashSet**: Mazmorra con orden de inserción preservado
- **Comparators**: Ordenamiento personalizado de elementos

## 🎭 Clases Principales

### 🏰 `Hogwarts` (Singleton)
```java
public class Hogwarts {
    private static Hogwarts instance;
    private HashMap<String,House> houseMap;
    private LinkedHashSet<Character> Dungeon;
    private ArrayList<MagicWand> replacements;
}
```
**Responsabilidades:**
- Gestión central del sistema de duelos
- Coordinación entre casas y personajes
- Administración de varitas de reemplazo
- Control de la mazmorra

### 👤 `Character` (Clase Abstracta)
```java
public abstract class Character {
    protected MagicWand wand;
    protected String name;
    protected double energyPoints;
    protected double offensivePoints;
    protected double defensivePoints;
}
```
**Tipos de Personajes:**
- **`Offensive`**: Especializados en ataques (Ej: Harry Potter)
- **`Defensive`**: Especializados en defensa (Ej: Hermione Granger)

### 🏠 `House`
```java
public class House {
    private ArrayList<Character> Wizards;
    private String name;
}
```
**Funcionalidades:**
- Gestión de magos por casa
- Selección de combatientes
- Estadísticas de casa

### 🪄 `MagicWand` (Interface)
```java
public interface MagicWand {
    double offensive(double energy, double offensive);
    double defensive(double energy, double defensive);
    String getNameWand();
    String getTypeWand();
}
```
**Implementaciones:**
- **`OffensiveHawthorn`**: Varitas especializadas en ataque
- **`HollyDefensive`**: Varitas especializadas en defensa

### 🧪 `Potion` (Decorator)
```java
public abstract class Potion extends Character {
    protected Character characterWithPotion;
}
```
**Tipos de Pociones:**
- **`FelixFelicis`**: Mejora significativa de todas las habilidades
- **`Invigoration`**: Boost de energía específico

## 🚀 Instalación y Configuración

### 📋 Requisitos Previos
- **Java JDK 8** o superior
- **BlueJ IDE** (recomendado) o cualquier IDE compatible con Java
- **Sistema Operativo**: Windows, macOS, o Linux

### 📥 Instalación

1. **Clonar el repositorio:**
```bash
git clone https://github.com/CCamberoR/Potter-s-Dare.git
cd "Potter-s-Dare"
```

2. **Abrir en BlueJ:**
   - Abrir BlueJ
   - File → Open Project
   - Seleccionar la carpeta del proyecto

3. **Compilar el proyecto:**
   - En BlueJ: Build → Rebuild Package
   - O compilar todas las clases manualmente

## 🎮 Cómo Ejecutar el Proyecto

### 🎯 Ejecución Básica

1. **En BlueJ:**
   - Click derecho en la clase `Client`
   - Seleccionar `new Client()`
   - La simulación comenzará automáticamente

2. **Desde línea de comandos:**
```bash
javac *.java
java Client
```

### ⚙️ Configuración Personalizada

Para modificar la configuración del juego, edita el método `InitData()` en la clase `Client`:

```java
public void InitData(){
    // Crear varitas personalizadas
    MagicWand customWand = new OffensiveHawthorn("MiVarita");
    
    // Crear personajes personalizados
    Character customCharacter = new Offensive("MiPersonaje");
    
    // Configurar casa personalizada
    House customHouse = new House("MiCasa");
    customHouse.addCharacter(customCharacter);
}
```

## ⚔️ Mecánicas del Juego

### 🎲 Sistema de Duelos

1. **Selección de Combatientes:**
   - Un personaje de cada casa (si está disponible)
   - Selección rotatoria para garantizar equidad

2. **Cálculo de Combate:**
   ```
   Puntos de Ataque = Varita.offensive(energía, ataque_base)
   Puntos de Resistencia = Varita.defensive(energía, defensa_base)
   
   Daño = max(0, Puntos_Ataque - Puntos_Resistencia)
   Nueva_Energía = Energía_Actual - Daño
   ```

3. **Resultados del Duelo:**
   - **Energía > 0**: Regresa a su casa con nueva varita
   - **Energía ≤ 0**: Enviado a la mazmorra

### 🏆 Condiciones de Victoria

- **Victoria por Eliminación**: Solo queda una casa con personajes
- **Victoria por Turnos**: Límite máximo de turnos alcanzado
- **Empate**: Múltiples casas con el mismo número de personajes

### 📊 Ejemplo de Salida del Sistema

```
turn: <0>
characters who are going to duel:
--------------------------------
character:<Harry Potter> <e: 20.0> <o: 32.5> <d: 28.0> <wand: HarryW (OffensiveHawthornBehavior)>
character:<Cedric Diggory> <e: 20.0> <o: 20.0> <d: 35.0> <wand: CedricW (OffensiveHawthornBehavior)>

duels:
-----
<Harry Potter> is dueling against <Cedric Diggory>
attack points of <Harry Potter> are: <45.2>
resistance points of <Cedric Diggory> are: <23.0>
the remaining energy of <Cedric Diggory> after the duel are: <-2.2>

duel results:
------------
character:<Harry Potter> returns to house
character:<Cedric Diggory> goes to the dungeon
```

## 📁 Estructura de Archivos

```
POTTER'S DARE/
├── 📄 Client.java                 # Clase principal y configuración
├── 🏰 Hogwarts.java              # Singleton - Gestión central
├── 👤 Character.java             # Clase abstracta base de personajes
├── 🏠 House.java                 # Gestión de casas
├── 🪄 MagicWand.java             # Interface de varitas mágicas
├── 🧪 Potion.java                # Clase abstracta de pociones
│
├── 👥 Personajes/
│   ├── Offensive.java            # Personajes ofensivos
│   └── Defensive.java            # Personajes defensivos
│
├── 🪄 Varitas/
│   ├── OffensiveHawthorn.java    # Varitas ofensivas
│   ├── HollyDefensive.java       # Varitas defensivas
│   └── Wand.java                 # Implementación base
│
├── 🧪 Pociones/
│   ├── FelixFelicis.java         # Poción de suerte
│   └── Invigoration.java         # Poción de vigor
│
├── 🔄 Comparadores/
│   ├── ComparatorAlphabeticName.java
│   ├── ComparatorEnergyPoints.java
│   ├── ComparatorOffensivePoints.java
│   ├── ComparatorDefensivePoints.java
│   └── ComparatorNameWand.java
│
├── 🧪 Tests/
│   ├── HouseTest.java
│   ├── OffensiveTest.java
│   ├── DefensiveTest.java
│   ├── FelixFelicisTest.java
│   └── InvigorationTest.java
│
├── 📚 doc/                       # Documentación Javadoc
│   ├── index.html
│   ├── Character.html
│   ├── Hogwarts.html
│   └── ...
│
├── 📄 README.TXT                 # README original
├── 📄 README.md                  # Este archivo
├── 📄 salida.txt                 # Ejemplo de salida del sistema
└── 📄 package.bluej              # Configuración de BlueJ
```

## 🧪 Testing

El proyecto incluye una suite completa de tests unitarios:

### 🔬 Tests Disponibles

1. **`HouseTest.java`**: Verificación de funcionalidades de casas
2. **`OffensiveTest.java`**: Tests para personajes ofensivos
3. **`DefensiveTest.java`**: Tests para personajes defensivos
4. **`FelixFelicisTest.java`**: Verificación de efectos de pociones
5. **`InvigorationTest.java`**: Tests de pociones de vigor

### ▶️ Ejecutar Tests

**En BlueJ:**
```
Click derecho en clase Test → Create Test Fixture → Run Tests
```

**Desde línea de comandos:**
```bash
javac -cp .:junit-platform-console-standalone.jar *.java
java -cp .:junit-platform-console-standalone.jar org.junit.platform.console.ConsoleLauncher --scan-classpath
```

## 📚 Documentación

El proyecto incluye documentación completa generada con Javadoc en la carpeta `doc/` con información detallada sobre todas las clases, métodos y ejemplos de uso.

## 👥 Autores

### 👨‍💻 Desarrolladores Principales

**Carlos Cambero Rojas**
- 🎯 Especialización: Arquitectura del sistema, Patrones de diseño

**Sergio López López**
- 🎯 Especialización: Mecánicas de juego, Testing

### 🤝 Contribuciones

- **Diseño del Sistema**: Ambos autores colaboraron en la arquitectura general
- **Implementación**: División equitativa de clases y funcionalidades
- **Testing**: Suite de tests desarrollada conjuntamente
- **Documentación**: Documentación Javadoc y README colaborativo

## 📄 Información Adicional

### 📅 Información del Proyecto

- **Fecha de Inicio**: 03/01/2020
- **Versión Actual**: 1.0
- **Lenguaje**: Java 8+
- **IDE Recomendado**: BlueJ
- **Patrón de Arquitectura**: MVC con elementos de Domain-Driven Design

### 🎓 Contexto Académico

Este proyecto fue desarrollado como parte del curso de **Programación Orientada a Objetos (POO)**, implementando conceptos avanzados como:

- **Patrones de Diseño**: Singleton, Strategy, Decorator, Template Method
- **Estructuras de Datos**: HashMap, ArrayList, LinkedHashSet
- **Principios SOLID**: Aplicación práctica de principios de diseño
- **Testing**: Desarrollo dirigido por tests (TDD)

### 🔄 Posibles Mejoras Futuras

1. **Interface Gráfica**: Implementación de GUI con JavaFX o Swing
2. **Persistencia**: Sistema de guardado y carga de partidas
3. **Inteligencia Artificial**: IA para decisiones estratégicas
4. **Multijugador**: Capacidad para múltiples jugadores humanos
5. **Nuevas Mecánicas**: Hechizos especiales, eventos aleatorios

---

*"It is our choices, Harry, that show what we truly are, far more than our abilities." - Albus Dumbledore*

**¡Que comience el duelo! ⚡🏰**
