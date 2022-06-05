It is well known that after a long day at work, penguins like to go to the pub and play a game of craps about the fish they caught that day. The game Lucky Penguin is the most popular because you don't have to think too much and you can leave the game at any time. In addition, the game board can be drawn on the table quickly and easily.

Game board drawn by a real penguin



The rules of the game
The game board consists of 11 fields, from F2 to F12, on which you can place or remove fish in the course of the game. At the beginning of the game all fields are empty.

The game can be played by 2 to any number of penguins. Let nnn be the number of penguins playing along. Every penguin starts out with mmm fish. The penguins are numbered from 0 to n−1n-1n−1. Your turn will be taken one after the other, first penguin 0, then penguin 1, and so on until penguin n−1n-1n−1. Then it's back to Penguin 0.

When it is a penguin turn, he rolls two dice. The total of the two dice is assigned to the field with this number. So if a penguin rolls B. 3 and 2, this corresponds to field 5.

For all fields except 2, 7 and 12: If a fish is already on the field, the penguin wins the fish. But if the field was empty, the penguin must put a fish on the field.

In space 7 there is a wedding: The penguin must put a fish on the field, regardless of how many fish there are already.

In field 2 the penguin is a lucky penguin: The lucky penguin wins all fish from all fields except from field 7!

In space 12 the penguin is a king penguin: The king penguin wins all fish that are on the board!

The current penguin can then decide to stop immediately and keep all of his fish. If he's out of fish anyway, he must stop playing.

Then it's the turn of the next (still playing) penguin. The game continues like this until all but one are out of fish or have voluntarily stopped. Then the last penguin to play wins all fish on the board, if there are any. The game is then ended.

At the end of the game, the penguins that have the most fish win. Mind you, there can be several winning penguins.



Program Statemnt
Initialization
Your program should query the number nnn of penguins playing along with the number mmm of fish that each penguin has at the beginning of the game.

The command prompt via the console should look like this:

Number of penguins:
Starting fish per penguin:
If nnn is less than 2, the following error message should be issued repeatedly and n should be read in again until n&gt;1n&gt;1n>1 is entered:

Number of penguins should be >1:
It should also be ensured that m&gt;0m&gt;0m>0 applies, with the following input prompt in the event of an error:

Starting fish should be >0:
Course of a move
Each time before a penguin turns, the game board is displayed in the form of ASCII art. To do this, use the MiniJava method writeBoard (), which takes the number of fish in the fields F3, F4, F5, …, F11 as a parameter and outputs the board as follows:

┌─── o  o  o ───┐
│    │╲╱ ╲╱│    │
│    │_F12_│    │
├────┬─────┬────┤
│ F9 │ F10 │ F11│
│  0 │  0  │  0 │
├────┼─────┼────┤
│ F6 │ F7  │ F8 │
│  0 │  0  │  0 │
├────┼─────┼────┤
│ F3 │ F4  │ F5 │
│  0 │  0  │  0 │
├────┴─────┴────┤
│ ('>       <') │
│ ╱/╲  F2   ╱\╲ │
├─V_╱─┐   ┌─╲_V─┤
└─────┴───┴─────┘
When it comes to a penguin, the following should be displayed:

It's penguin <p> turn:
where <p> corresponds to the number of the penguin.

Your program should now determine whether this penguin is the last penguin to play. If so, the following is issued before the game ends:

You are the last penguin to play! You win all the fish on the board!
If not, the penguin rolls the two dice. Use the MiniJava method dice (), which returns a random natural number between 1 and 6. The numbers rolled should be displayed as follows:

<w1> + <w2> = <sum> was rolled.
where <w1> and <w2> are the first and second numbers rolled, and <sum> is the sum of them.

Depending on the total number of points rolled, your program should execute the rule described above and output the one corresponding line from the following:

Lucky penguin! You win all fish on the board except F7!
King Penguin! You win all the fish on the board!
Wedding! You give a fish and place it on F7.
They take the fish from F <sum>.
You put a fish on F <sum>.
Then it should be output how many fish the current penguin has after following the above rules:

You now have <f> fishes!
Or if <f> = 1, then:

You now have 1 fish!
The only thing left to do is to decide whether this penguin will stop playing or not. If he has lost all fish, he immediately stops:

You have lost all fish, so you can no longer play!
Otherwise, he still has the option of voluntarily quitting. Your program should read in an integer for this:

Enter 1 to exit now:
If the number 1 is actually entered, the penguin stops immediately. When a penguin stops playing, it never comes back from that point.

The end of the game
At the end all the winning penguins should be handed out. If several penguins have won, they should be sorted in ascending order. In the following example, Penguin 1 and Penguin 5, who both have 17 fish, win:

The winning penguins with 17 fish:
Penguin 1
Penguin 5


Example
 Example 1 1 of 1 tests passing
Number of penguins:
> 1
Number of penguins should be >1:
> 3
Starting fish per penguin:
> -2
Start fish should be >0:
> 2
┌─── o  o  o ───┐
│    │╲╱ ╲╱│    │
│    │_F12_│    │
├────┬─────┬────┤
│ F9 │ F10 │ F11│
│  0 │  0  │  0 │
├────┼─────┼────┤
│ F6 │ F7  │ F8 │
│  0 │  0  │  0 │
├────┼─────┼────┤
│ F3 │ F4  │ F5 │
│  0 │  0  │  0 │
├────┴─────┴────┤
│ ('>       <') │
│ ╱/╲  F2   ╱\╲ │
├─V_╱─┐   ┌─╲_V─┤
└─────┴───┴─────┘
It's penguin 0 turn:
5 + 6 = 11 was rolled.
You put a fish on F11.
You now have 1 fish!
Enter 1 to exit now:
> 0
┌─── o  o  o ───┐
│    │╲╱ ╲╱│    │
│    │_F12_│    │
├────┬─────┬────┤
│ F9 │ F10 │ F11│
│  0 │  0  │  1 │
├────┼─────┼────┤
│ F6 │ F7  │ F8 │
│  0 │  0  │  0 │
├────┼─────┼────┤
│ F3 │ F4  │ F5 │
│  0 │  0  │  0 │
├────┴─────┴────┤
│ ('>       <') │
│ ╱/╲  F2   ╱\╲ │
├─V_╱─┐   ┌─╲_V─┤
└─────┴───┴─────┘
It's penguin 1 turn:
5 + 6 = 11 was rolled.
You take the fish from F11.
You now have 3 fishes!
Enter 1 to exit now:
> 1
┌─── o  o  o ───┐
│    │╲╱ ╲╱│    │
│    │_F12_│    │
├────┬─────┬────┤
│ F9 │ F10 │ F11│
│  0 │  0  │  0 │
├────┼─────┼────┤
│ F6 │ F7  │ F8 │
│  0 │  0  │  0 │
├────┼─────┼────┤
│ F3 │ F4  │ F5 │
│  0 │  0  │  0 │
├────┴─────┴────┤
│ ('>       <') │
│ ╱/╲  F2   ╱\╲ │
├─V_╱─┐   ┌─╲_V─┤
└─────┴───┴─────┘
It's penguin 2 turn:
1 + 1 = 2 was rolled.
Lucky penguin! You win all fish on the board except F7!
You now have 2 fishes!
Enter 1 to exit now:
> 123
┌─── o  o  o ───┐
│    │╲╱ ╲╱│    │
│    │_F12_│    │
├────┬─────┬────┤
│ F9 │ F10 │ F11│
│  0 │  0  │  0 │
├────┼─────┼────┤
│ F6 │ F7  │ F8 │
│  0 │  0  │  0 │
├────┼─────┼────┤
│ F3 │ F4  │ F5 │
│  0 │  0  │  0 │
├────┴─────┴────┤
│ ('>       <') │
│ ╱/╲  F2   ╱\╲ │
├─V_╱─┐   ┌─╲_V─┤
└─────┴───┴─────┘
It's penguin 0 turn:
3 + 4 = 7 was rolled.
Wedding! You give a fish and place it on F7.
You now have 0 fishes!
You have lost all fish, so you can no longer play!
┌─── o  o  o ───┐
│    │╲╱ ╲╱│    │
│    │_F12_│    │
├────┬─────┬────┤
│ F9 │ F10 │ F11│
│  0 │  0  │  0 │
├────┼─────┼────┤
│ F6 │ F7  │ F8 │
│  0 │  1  │  0 │
├────┼─────┼────┤
│ F3 │ F4  │ F5 │
│  0 │  0  │  0 │
├────┴─────┴────┤
│ ('>       <') │
│ ╱/╲  F2   ╱\╲ │
├─V_╱─┐   ┌─╲_V─┤
└─────┴───┴─────┘
It's penguin 2 turn:
You are the last penguin to play! You win all the fishes on the board!
The winning penguins with 3 fish:
Penguin 1
Penguin 2
The lines that begin with "> " mark the user input and are not output by the program. They only serve to make it easier to understand.
