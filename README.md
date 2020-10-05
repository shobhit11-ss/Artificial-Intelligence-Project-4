# Artificial-Intelligence-Project-4
Game of Sticks

Name: Shobhit Singh
Roll: 1801168

Description: game_of_sticks_n.java
----------------------------------
As the name suggests the file "game_of_sticks_n.java is a Game of sticks in which a human plays against the AI. The number of starting sticks is to be given by the user. After this a toss is done to decide who will draw the stick(s) first. The human and the AI take their chances alternatively to draw the sticks and atleast 1 and atmost 3 sticks can be drawn at a time by both the parties.

Description: game_ai.java
-------------------------
As the name suggests the file "game_ai.java" is a Game of Sticks in which an AI plays against another AI. The number of starting sticks is to be given by the user. After this a toss is done to decide who will draw the stick(s) first.The AIs take their chances alternatively to draw the sticks and atleast 1 and atmost 3 sticks can be drawn at a time by both the parties

Winning Criteria
----------------
In both the files the player who has to draw the last stick loses the game.


Data Structure Used
-------------------
We used a tree that uses the min/max algorithm. Min/Max algorithm is a recursive algorithm. It always choses the optimal move for a player assuming that the other player is also playing optimally.
If there are b legal moves, i.e., b nodes at each point and the maximum depth of the tree is m, the time complexity of the minimax algorithm is of the order b^m(O(b^m)).

Algorithms Which We Have Used
---------------
We have used Alpha-Beta pruning to search the Min/Max heap. It is a search algorithm whose aim is to decrease the number of nodes that are to be evaluated by the min/max trees. If we apply alpha-beta pruning to a standard minimax algorithm, it returns the same move as the standard one, but it removes (prunes) all the nodes that are possibly not affecting the final decision.

Alpha: It is the best choice so far for the player MAX. We want to get the highest possible value here.
Beta: It is the best choice so far for MIN, and it has to be the lowest possible value.

