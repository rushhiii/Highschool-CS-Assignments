import random

while True:

  userAction = input("\nEnter a choice (rock, paper, scissors): ")
  possibleActions = ["rock", "paper", "scissors"]
  computerAction = random.choice(possibleActions)
  print(f"\nYou chose {userAction}, computer chose {computerAction}.\n")

  if userAction == computerAction:
    print(f"Both players selected {userAction}. It's a tie!")
  elif userAction == "rock":
    if computerAction == "scissors":
      print("Rock smashes scissors! Congratulations You win!")
    else:
      print("Paper covers rock! You lose.")
  elif userAction == "paper":
    if computerAction == "rock":
      print("Paper covers rock! Congratulations You win!")
    else:
      print("Scissors cuts paper! You lose.")
  elif userAction == "scissors":
    if computerAction == "paper":
      print("Scissors cuts paper! Congratulations You win!")
    else:
      print("Rock smashes scissors! You lose.")

  check = input(
    "\nDo you want to start a new game?\nEnter Y for yes and N for no: ")
  if check.upper() == "Y":
    continue
  elif check.upper() == "N":
    print("\nGame Over")
    break