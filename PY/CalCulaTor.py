txt = "Welcome to a Python Calculator"
text = txt.center(70, "-")
print(text)


# Fuction for Multiplication
def mul():
  print("\n")
  txt = "\Multiplication/"
  text = txt.center(70, "-")
  print(text)
  print("Enter two numbers that you want to Multiply")
  num_1 = int(input("First number: "))
  num_2 = int(input("Second number: "))
  operation = num_1 * num_2
  answer = round(operation)
  print("\n{} Multiplied by {} is {}".format(num_1, num_2, answer))
  for i in range(70):
    print("-", end="")
  print("\n")


# Fuction for Division
def div():
  print("\n")
  txt = "\Division/"
  text = txt.center(70, "-")
  print(text)
  print("Enter two numbers that you want to Divied")
  num_1 = int(input("First number: "))
  num_2 = int(input("Second number: "))
  operation = num_1 / num_2
  answer = round(operation)
  print("\n{} divided by {} is {}".format(num_1, num_2, answer))
  for i in range(70):
    print("-", end="")
  print("\n")


# Fuction for Subtraction
def sub():
  print("\n")
  txt = "\Subtraction/"
  text = txt.center(70, "-")
  print(text)
  print("Enter two numbers that you want to Subtract")
  num_1 = int(input("First number: "))
  num_2 = int(input("Second number: "))
  sum = num_1 - num_2
  print("\nThe Subtraction of {} and {} is {}".format(num_1, num_2, sum))
  for i in range(70):
    print("-", end="")
  print("\n")

# Fuction for float and int check
def check_user_input(input):
  try:
    # Convert it into integer
    val = int(input)
    return val
  except ValueError:
    try:
      # Convert it into float
      val = float(input)
      return val
    except ValueError:
      print("No.. input is not a number. It's a string")

# Fuction for Addition
def add():
  print("\n")
  txt = "\Addition/"
  text = txt.center(70, "-")
  print(text)
  print("Enter two numbers that you want to add")
  num_1 =  input("First number: ")
  input_1 = check_user_input(num_1)
  num_2 = input("Second number: ")
  input_2 = check_user_input(num_2)
  sum = input_1 + input_2
  print("\nThe Addition of {} and {} is {}".format(num_1, num_2, sum))
  for i in range(70):
    print("-", end="")
  print("\n")

# Fuction for Addition float
def add_f():
  print("\n")
  txt = "\Addition/"
  text = txt.center(70, "-")
  print(text)
  print("Enter two numbers that you want to add")
  num_1 = float(input("First number: "))
  num_2 = float(input("Second number: "))
  sum = num_1 + num_2
  print("\nThe Addition of {} and {} is {}".format(num_1, num_2, sum))
  for i in range(70):
    print("-", end="")
  print("\n")


# Function to break the program
def exit():
  print("\n")
  txt = "END"
  text = txt.center(70, "-")
  print(text)


# Function list to call them by number
def cal():
  function = int(
    input(
      "\nThe functions are as followed:\n1. Addition\n2. Subtraction\n3. Division\n4. Multiplication\n\nEnter a number from above to call that function: "
    ))
  if function == 1:
    add()
  elif function == 2:
    sub()
  elif function == 3:
    div()
  elif function == 4:
    mul()
  else:
    print("\nplease enter a valide input: ")


# yes/no loop
  check = input("\nDo you want to call a function again?(yes/no): ")
  if check == "yes":
    cal()
  elif check == "no":
    exit()
  else: 
    print("Enter a valide input: ")

cal()
