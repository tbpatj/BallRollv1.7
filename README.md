# DiverseGem

![Diverse Gem Logo](assets/pictures/DiverseGemLogo2.PNG)
<sub>Created in 2014</sub>

## Description

I made this game in 2014 for a club competition in jr high, I had a little bit of help on some of the maps, and found a couple of resources online for sounds and music. This readme file has been written almost 10 years later, so I might miss a couple of things. Also keep that in mind if you play the game you will find various bugs and glitches, it was my first big project. Hope you enjoy!

## Installation and Setup

DiverseGem Runs on Java, you can download a version of the Java Runtime Environment 8u341 needed [here](https://www.oracle.com/java/technologies/javase/javase8u211-later-archive-downloads.html)

Once java is installed you can open the associated systems (windows64, mac, etc) .jar file.
The .jar files are located under /game<br />

if you don't clone the repository onto your computer, you can copy the associated .jar file onto your machine, make sure to download the ballroll folder and put the .jar and ballroll folder in same directory.<br />

## Gameplay controls

<kbd>W</kbd>, <kbd>A</kbd>, <kbd>S</kbd>, <kbd>D</kbd> - Move<br />
<kbd>Space</kbd> - Jump<br />
<kbd>esc</kbd> - pause menu<br />
_Mousewheel_ - change 3rd person perspective / 1st person perspective<br />

## Additional Controls

<kbd>Right Shift</kbd> - Screenshot in game<br />
<kbd>Y</kbd> - slow mo, though it hasn't really seemed all that slow mo, I think it has a modifier of 1.5<br />
<kbd>R</kbd> - Save power ball position<br />
<kbd>G</kbd> - Respawn power ball to last saved position<br />
<kbd>Y</kbd> + <kbd>L</kbd> - Reset level<br />

## Editor

To enter the editor press <kbd>0</kbd>, while the application is in the intro screen<br />

you can load up custom maps by putting a .ply file in /game/ballroll/maps<br />

if you want to load in specific schematics into the editor, go inside the /game/ballroll/schematics directory and put in a schematic there. It should be able to load .ply files<br />

### Editor Controls

Basic Controls<br />
<kbd>esc</kbd> - pause menu<br />
<kbd>W</kbd>, <kbd>A</kbd>, <kbd>S</kbd>, <kbd>D</kbd> - Move horizontally<br />
<kbd>left shift</kbd> - Move down vertically<br />
<kbd>space</kbd> - Move up vertically<br />
<kbd>H</kbd> - put the ball position at the position of the editor cursor<br />
<kbd>U</kbd> - change between edit and play mode<br />

Cursor Controls<br />
<kbd>F</kbd> - add a vertex at the cursor position, add 3 and you'll create a triangle<br />
<kbd>G</kbd> - delete nearest triangle<br />
<kbd>R</kbd> - reset the current triangle you are creating, (example if you push f twice push R to reset and not comlete the triangle)<br />
<kbd>E</kbd> - Snap editor cursor to nearest edge, hold to stay snapped to that edge<br />
<kbd>Q</kbd> - Snap to nearest vertex, or the nearest mid point of a triangle<br />

Surface Properties<br />
_You can find the surface color properties if you hover you mouse near the bottom of the pause screen, just push <kbd>esc</kbd> to get there. The left three sliders are for R,G,B from top to bottom, the top right slider is the alpha value, the bottom right slider is your cursor speed._<br />
<kbd>'</kbd> - set color editing properties to the properties of the gravity crystal<br />
<kbd>Z</kbd> - flip the surface normal<br />
<kbd>T</kbd> - set the editor color selection to the nearest triangle<br />
<kbd>O</kbd> - set the nearest triangle to the current editor color selection<br />
<kbd>K</kbd> - smooths the normals of connected triangles at a specific position<br />

Schematic Controls<br />
You can find the schematic editor in the paused menu, in the top right it will be a blue button, click on that and you will find schematics you can load in, load one up and push <kbd>esc</kbd> to exit the pause menus <br />
<kbd>,</kbd> (comma) - clear the currently loaded schematic<br />
<kbd>.</kbd> (period) - load up a shape as the schematic<br />
<kbd>V</kbd> - paste in the currently loaded schematic, (you'll know when a schematic is loaded as it will appear transparent at the cursor)<br />
<kbd>Left Arrow</kbd>,<kbd>Right Arrow</kbd> - rotate the schematic<br />
<kbd>Down Arrow</kbd>, <kbd>Up Arrow</kbd> - scale the schematic<br />

Item Editor Controls<br />
<kbd>N</kbd> - Create new Item<br />
<kbd>1</kbd> - Edit closest item's type<br />
<kbd>M</kbd> - remove closest item<br />

Fun Additions<br />
<kbd>I</kbd> - spawn small particles at the cursor<br />
<kbd>P</kbd> - spawn a firework at the cursor<br />
<kbd>/</kbd> - render lightning from cursor to player<br />
<kbd>semi-colon</kbd> - rotate the viewport around the z-axis (y-axis in other engines)<br />

## Screenshots

![Storyline Gif](assets/gifs/Warning-BallRoll.gif)
![Ball Popping Gif](assets/gifs/Pop-BallRoll.gif)
<sub> Uses a version of LWJGL-2.9.1 </sub>
