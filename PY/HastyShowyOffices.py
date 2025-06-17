import turtle
# Creating a turtle object(pen)
pen = turtle.Turtle()
wn = turtle.Screen()
wn.setup(500, 500)


# Defining a method to draw curve
def curve():
  for i in range(200):

    # Defining step by step curve motion
    pen.right(1)
    pen.forward(1)


# Defining method to draw a full heart
def heart():

  # Set the fill color to red
  pen.speed(3200)
  pen.color('red', 'darkred')

  # Start filling the color
  pen.begin_fill()

  # Draw the left line
  pen.left(140)
  pen.forward(113)

  # Draw the left curve
  curve()
  pen.left(120)

  # Draw the right curve
  curve()

  # Draw the right line
  pen.forward(112)

  # Ending the filling of the color
  pen.end_fill()


# Defining method to write text
def txt():

  # Move turtle to air
  pen.up()

  # Move turtle to a given position
  pen.setpos(-40, 90)

  # Move the turtle to the ground
  pen.down()

  # Set the text color to lightgreen
  pen.color('white')

  # Write the specified text in
  # specified font style and size
  pen.write("Nishita", font=("Courier New", 16, "bold"))


# Draw a heart
heart()

# Write text
txt()

# To hide turtle
pen.ht()
turtle.exitonclick()


def increaseSize():
  size = pen.turtlesize()
  increase = (2 * num for num in size)
  pen.turtlesize(*increase)


wn.onkey(increaseSize, "x")
wn.listen()
