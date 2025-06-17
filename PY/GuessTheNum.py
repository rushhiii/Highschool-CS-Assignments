# Keep the game going until the user types “exit”
# Keep track of how many guesses the user has taken, and when the game ends, print this out.

import random

number = random.randrange(0, 10)
guess = 0
count = 0

while guess != number and guess != "exit":
  guess = input(
    "\nGuess a number between 1 and 9. \nWhen you want to end the game type 'exit': "
  )

  if guess == "exit":
    print("\nGame Over")
    break

  guess = int(guess)
  count += 1
  if guess not in range(1, 10):
    print("\nYou have to guess a number between 1 and 9!")
  elif guess < number:
    print("\nYou've guessed too low!")
  elif guess > number:
    print("\nYou've guessed too high!")
  else:
    if count == 1:
      print("\nYou rock! You've guessed it at the first try!")
    elif count <= 3:
      print("\nWell done! You've guessed it in just {} tries".format(count))
    elif count > 3:
      print("\nYou've guessed it! It took you {} tries!".format(count))