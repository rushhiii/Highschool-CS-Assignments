class Slider:
    def __init__(self, x, y, length, varValue, varText):
        self.x = x
        self.y = y
        self.length = length
        self.endPoint = self.x + self.length
        self.sliderX = self.x + self.length * 0.5
        self.varValue = abs(varValue)
        self.varText = varText + " = "
        self.rangeMin = -self.roundUpNear10th(self.varValue)
        self.rangeMax = self.roundUpNear10th(self.varValue)
        self.adjustment2 = varValue
        self.sliderX = getMapValue(varValue, (self.rangeMin), (self.rangeMax), self.x, self.endPoint)
    
    def custRoundTo(self, num):
        numStr = str(num)
        rounded = ""
        decFound = False

        for i in range(len(numStr)):
            if numStr[i] == "." and numStr[i + 1] != "0":
                rounded += numStr[i] + numStr[i + 1]
                decFound = True
                break
            elif numStr[i] == "." and numStr[i + 1] == "0":
                break
            else:
                rounded += numStr[i]
    
        if not decFound and rounded == "-0":
            rounded = "0"
    
        return rounded
    
    def roundUpNear10th(self, num):
        return int(10 * (num // 10 + 1))
    
    def draw(self):
        strokeWeight(5)
        textAlign(LEFT, CENTER)
        # fill(0) # light 
        fill(255) # dark
        # text(self.varText + str(round(self.adjustment2 * 10) / 10), self.x, self.y - 30)
        text(self.varText + self.custRoundTo(self.adjustment2), self.x, self.y - 25)
        fill(110,110,110,255) # dark
        textAlign(RIGHT, CENTER)
        text(self.rangeMin, self.x - 15, self.y)
        textAlign(LEFT, CENTER)
        text(self.rangeMax, self.endPoint + 15, self.y)
    
        # stroke(229, 229, 229, 255) # light
        stroke(50, 50, 50, 255) # dark
        line(self.x, self.y, self.endPoint, self.y)
    
        noStroke()
        # fill(173, 173, 173, 255) # light
        fill(83, 83, 83, 255) # dark
        circle((self.x + self.length * 0.5), self.y, 3)
    
        noStroke()
        # fill(113, 156, 223, 150) # light
        fill(149, 108, 45, 150) # dark
        circle(self.sliderX, self.y, 25)
        # fill(47, 114, 220, 255) # light
        fill(208, 141, 35, 255) # dark
        circle(self.sliderX, self.y, 5)
    
    def mouseClicked(self):
        if self.x <= mouseX <= self.endPoint and self.y - 10 <= mouseY <= self.y + 10:
            self.sliderX = mouseX
            self.adjustment2 = 1.0 * (self.sliderX - self.x) / self.length * (self.rangeMax * 2) + (self.rangeMin)
    
    def mouseDragged(self):
        if self.x <= mouseX <= self.endPoint and self.y - 10 <= mouseY <= self.y + 10:
            self.sliderX = mouseX
            self.adjustment2 = 1.0 * (self.sliderX - self.x) / self.length * (self.rangeMax * 2) + (self.rangeMin)
        
class Equation:
    def __init__(self, equationStr):
        self.equationStr = equationStr
        self.a, self.b, self.c = 0.0, 0.0, 0.0
    
    def updateEquation(self, textInput):
        self.equationStr = textInput
        self.a, self.b, self.c = self.extractABCvalues()
        
    def extractABCvalues(self):
        s = self.equationStr
        a, b, c = 0.0, 0.0, 0.0
        currCoefficient = ""
    
        for i in range(len(s)):
            if s[i].isdigit() or s[i] == '.' or (s[i] == '-' and (i == 0 or s[i-1] in ['+', '-', ' ', '^'])):
                currCoefficient += s[i]
            elif s[i] == "x":
                if not currCoefficient or currCoefficient == "-":
                    currCoefficient += "1"
                elif i + 1 < len(s) and s[i + 1] == "^":
                    if i + 2 < len(s) and s[i + 2] == "2":
                        a = float(currCoefficient)
                        currCoefficient = ""
                        i += 2
                else:
                    b = float(currCoefficient)
                    currCoefficient = ""
            elif s[i] == "+":
                if currCoefficient:
                    if b == 0.0:
                        b = float(currCoefficient)
                    else:
                        c = float(currCoefficient)
                    currCoefficient = ""
            elif s[i] == "-":
                if currCoefficient:
                    if b == 0.0:
                        b = float(currCoefficient)
                    else:
                        c = float(currCoefficient)
                    currCoefficient = "-"
    
        if currCoefficient:
            if b == 0.0:
                b = float(currCoefficient)
            else:
                c = float(currCoefficient)
    
        return a, b, c
    
    def standardForm(self, a, b, c):
        equationStr = ""
    
        a = float(a)
        b = float(b)
        c = float(c)
    
        if a != 0:
            if a == 1 or a == -1:
                if a < 0:
                    equationStr += "-x^2"
                else:
                    equationStr += "x^2"
            else:
                equationStr += str(a) + "x^2"
        if b != 0:
            if b == 1 or b == -1:
                if equationStr != "":
                    if b < 0:
                        equationStr += "-x"
                    else:
                        equationStr += "+x"
                else:
                    if b < 0:
                        equationStr += "-x"
                    else:
                        equationStr += "x"
            else:
                if equationStr != "":
                    if b < 0:
                        equationStr += ""
                    elif a != 1:
                        equationStr += "+"
                equationStr += str(b) + "x"
        if c != 0:
            if equationStr != "":
                if c < 0:
                    equationStr += ""
                else:
                    equationStr += "+"
            equationStr += str(c)
    
        if equationStr == "":
            equationStr = "ax^2+bx+c"
    
        return equationStr

class Graph:
    def __init__(self, width, height):
        self.width = width
        self.height = height
    
    def plotStandardForm(self, a, b, c):
        stroke(56, 187, 191, 255) # blue
        # stroke(225, 0, 0) # red
        # stroke(149,108,45,255) # orange
        strokeWeight(3)
    
        # Adjusted to start from the center
        prevX = -int(self.width / 4)
        prevY = a * prevX ** 2 + b * prevX + c
    
        for x in range(-int(self.width / 2) + 1, int(self.width / 2)):
            y = a * x ** 2 + b * x + c
            line(prevX + self.width / 2 + 300, self.height - prevY - self.height / 2, x + self.width / 2 + 300, self.height - y - self.height / 2)
            prevX, prevY = x, y
    
    def drawScale(self, step, scaleFactor, focusX, focusY):
        stroke(110,110,110,255) # dark)
        strokeWeight(1)
    
        # Vertical lines
        for x in range(int(-self.width / 2), int(self.width / 2), step):
            line(x * scaleFactor + focusX, focusY - self.height / 2, x * scaleFactor + focusX, focusY + self.height / 2)
    
        # Horizontal lines
        for y in range(int(-self.height / 2), int(self.height / 2), step):
            line(focusX - self.width / 2, focusY - y * scaleFactor, focusX + self.width / 2, focusY - y * scaleFactor)
    
        stroke(200,200,200,255) # dark)
        strokeWeight(2)
        line(focusX - self.width / 2, focusY, focusX + self.width / 2, focusY)
        line(focusX, focusY - self.height / 2, focusX, focusY + self.height / 2)


class TextBox:
    def __init__(self, x, y, width, height, default_text):
        self.x = x
        self.y = y
        self.width = width
        self.height = height
        self.text = default_text
        self.storeInputText = ""
        self.active = False
        self.checkClick = ">Click on the box to type"
    
    def draw(self):
        fill(0)
        # fill(149,108,45,255)
        stroke(149,108,45,255)
        rect(self.x, self.y, self.width, self.height)
        # fill(0) # light
        fill(255) # dark
        textSize(14)
        text("Tip:\n          Try entering somthing similar to\n           0.2x^2+2x+18", 20, height - 200)
        textSize(15)
        textAlign(LEFT, CENTER)
        text(self.checkClick, self.x, (self.y + self.height / 2) + 28)
        text(self.storeInputText, self.x + 5, self.y + self.height / 2)
        
    
    def clicked(self, mx, my): 
        if self.x <= mx <= self.x + self.width and self.y <= my <= self.y + self.height:
            self.active = True
            self.checkClick = ""
        else:
            self.checkClick = ">Click on the box to type"
            self.active = False
    
    def keyTyped(self, key):
        allowedChars = "0123456789.x^+-"
    
        if self.active:
                if key == DELETE or key == BACKSPACE:
                    self.storeInputText = self.storeInputText[:-1]
                elif key == ENTER:
                    self.active = False
                    self.checkClick = ">Click on the box to type"
                    self.text = self.storeInputText
                    self.storeInputText = ""
                else:
                    if key in allowedChars:
                        self.storeInputText += key

def getMapValue(value, inRangeMin, inRangeMax, outRangeMin, outrangeMax):
    return (value - inRangeMin) * (outrangeMax - outRangeMin) // (inRangeMax - inRangeMin) + outRangeMin
    
def setup():
    global equation, sliders, graph, equationStr, wasUserInput, textInput
    
    equationStr = ""
    textInput = TextBox(20, height - 80, 250, 30, equationStr)
    equation = Equation(equationStr)
    sliders = [
        Slider(50, 130, 200, equation.a, "a"),
        Slider(50, 130 + 60, 200, equation.b, "b"),
        Slider(50, 130 + 60 + 60, 200, equation.c, "c")
        ]
    
    graph = Graph(600, 600)
    size(900, 600)
    
def draw():
    global equation, sliders, graph, equationStr, textInput
    # background(255) # light
    background(0) # dark
    
    # Update the equation string based on slider values
    equationStr = equation.standardForm(sliders[0].custRoundTo(sliders[0].adjustment2), sliders[1].custRoundTo(sliders[1].adjustment2), sliders[2].custRoundTo(sliders[2].adjustment2))
    
    # Draw the equation and sliders on the left side
    for slider in sliders:
        slider.draw()
    
    # Draw the text box
    textInput.draw()
    
    # Draw the parabola using standard form on the right side
    graph.drawScale(50, 1.0, graph.width / 2 + 300, graph.height / 2)
    graph.plotStandardForm(sliders[0].adjustment2, sliders[1].adjustment2, sliders[2].adjustment2)
    
    # Display the equation at the top
    textAlign(TOP, LEFT)
    textSize(20)
    # fill(0) # light
    fill(255) # dark
    text("y = " + equationStr, 30, 50)
    
    textSize(16)
    text("Enter a quadratic equation in\nstandard form:", 20, height - 120)
    
def mouseClicked():
    global equation, sliders, graph, textInput
    for slider in sliders:
        slider.mouseClicked()
    textInput.clicked(mouseX, mouseY)
    
def mouseDragged():
    global equation, sliders, graph
    for slider in sliders:
        slider.mouseDragged()
    
def keyTyped():
    global textInput, equation, sliders, graph
    textInput.keyTyped(key)
    
    if key == ENTER:
        # Update the equation with the new text input
        equation.updateEquation(textInput.text)
        equationStr = equation.standardForm(sliders[0].custRoundTo(sliders[0].adjustment2), sliders[1].custRoundTo(sliders[1].adjustment2), sliders[2].custRoundTo(sliders[2].adjustment2))
    
        sliders = [
        Slider(50, 130, 200, equation.a, "a"),
        Slider(50, 130 + 60, 200, equation.b, "b"),
        Slider(50, 130 + 60 + 60, 200, equation.c, "c")
        ]
    
        # Redraw the graph with the updated equation and sliders
        for slider in sliders:
            slider.draw()
    
        # Draw the text box
        textInput.draw()
    
        # Draw the parabola using standard form on the right side
        graph.drawScale(50, 1.0, graph.width / 2 + 300, graph.height / 2)
        graph.plotStandardForm(sliders[0].adjustment2, sliders[1].adjustment2, sliders[2].adjustment2)
    
        # Display the equation at the top
        textAlign(TOP, LEFT)
        textSize(20)
        # fill(0) # light
        fill(255) # dark
        text("y = " + equationStr, 30, 50)
    
    
#==================================================================================================================
# def draw():
#     global equation, sliders, graph, equationStr
#     background(255)

#     # Update the equation string based on slider values
    
#     equationStr =  "(" + sliders[0].custRoundTo(sliders[0].adjustment2) + "x^2)+(" + sliders[1].custRoundTo(sliders[1].adjustment2) + "x)+(" + sliders[2].custRoundTo(sliders[2].adjustment2)+ ")"

#     # Draw the equation and sliders on the left side
#     for slider in sliders:
#         slider.draw()

#     # Draw the parabola using standard form on the right side
#     graph.drawScale(50, 1.0, graph.width / 2 + 300, graph.height / 2)
#     graph.plotStandardForm(sliders[0].adjustment2, sliders[1].adjustment2, sliders[2].adjustment2)

#     # Display the equation at the top
#     textAlign(TOP, LEFT)
#     textSize(20)
#     fill(0)
#     text("Equation: " + equationStr, 20, 50)

#     textSize(15)
#     # for taking user Input
#     text(">Enter a quadratic equation in standared form: ax^2+bx+c", 20, height - 100)    
#     # rect()
#     # text()

# def mouseClicked():
#     global equation, sliders, graph
#     for slider in sliders:
#         slider.mouseClicked()

# def mouseDragged():
#     global equation, sliders, graph
#     for slider in sliders:
#         slider.mouseDragged()



# def draw():
#     global equation, sliders, graph, equationStr, textInput
#     background(255)

#     # Update the equation string based on slider values
#     if sliders[0].custRoundTo(sliders[0].adjustment2) == sliders[1].custRoundTo(sliders[1].adjustment2) == sliders[2].custRoundTo(sliders[2].adjustment2)== "0":
#         equationStr =  "ax^2+bx+c"
#     elif sliders[0].custRoundTo(sliders[0].adjustment2) == "0":
#         equationStr = "(" + sliders[1].custRoundTo(sliders[1].adjustment2) + "x)+(" + sliders[2].custRoundTo(sliders[2].adjustment2)+ ")"
#     elif sliders[1].custRoundTo(sliders[1].adjustment2) == "0":
#         equationStr = "(" + sliders[0].custRoundTo(sliders[0].adjustment2) + "x^2)+(" + sliders[2].custRoundTo(sliders[2].adjustment2)+ ")"
#     elif sliders[2].custRoundTo(sliders[2].adjustment2) == "0":
#         equationStr =  "(" + sliders[0].custRoundTo(sliders[0].adjustment2) + "x^2)+(" + sliders[1].custRoundTo(sliders[1].adjustment2) + "x)"
#     else:
#         equationStr =  "(" + sliders[0].custRoundTo(sliders[0].adjustment2) + "x^2)+(" + sliders[1].custRoundTo(sliders[1].adjustment2) + "x)+(" + sliders[2].custRoundTo(sliders[2].adjustment2)+ ")"

#     # Draw the equation and sliders on the left side
#     for slider in sliders:
#         slider.draw()

#     # Draw the text box
#     textInput.draw()

#     # Draw the parabola using standard form on the right side
#     graph.drawScale(50, 1.0, graph.width / 2 + 300, graph.height / 2)
#     graph.plotStandardForm(sliders[0].adjustment2, sliders[1].adjustment2, sliders[2].adjustment2)

#     # Display the equation at the top
#     textAlign(TOP, LEFT)
#     textSize(20)
#     fill(0)
#     text("Equation: " + equationStr, 20, 50)

#     textSize(15)
#     # Display the instruction for user input
#     text(">Enter a quadratic equation in standard form:", 20, height - 100)

# def mouseClicked():
#     global equation, sliders, graph, textInput
#     for slider in sliders:
#         slider.mouseClicked()
#     textInput.clicked(mouseX, mouseY)

# def mouseDragged():
#     global equation, sliders, graph
#     for slider in sliders:
#         slider.mouseDragged()

# def keyTyped():
#     global textInput, equation, sliders, graph, wasUserInput
#     textInput.keyTyped(key)

#     # Check if the pressed key is Enter (keyCode 10)
#     if key == ENTER:
#         # Update the equation with the new text input
#         wasUserInput = 1
#         equation.updateEquation(textInput.text)
#         textInput = ""
#         # Redraw the graph with the updated equation
#         background(255)
#         for slider in sliders:
#             slider.draw()
#         textInput.draw()
#         graph.drawScale(50, 1.0, graph.width / 2 + 300, graph.height / 2)
#         graph.plotStandardForm(sliders[0].adjustment2, sliders[1].adjustment2, sliders[2].adjustment2)
#         textAlign(TOP, LEFT)
#         textSize(20)
#         fill(0)
#         text("Equation: " + equation.standardForm(), 20, 50)
#         textSize(15)
#         text(">Enter a quadratic equation in standard form:", 20, height - 100)
        


# def draw():
#     global equation, sliders, graph, button

#     background(255)

#     equationStr =  "(" + sliders[0].custRoundTo(sliders[0].adjustment2) + "x^2)+(" + sliders[1].custRoundTo(sliders[1].adjustment2) + "x)+(" + sliders[2].custRoundTo(sliders[2].adjustment2)+ ")"

#     textAlign(TOP, LEFT)
#     textSize(20)
#     fill(0)
#     text("Equation: " + equationStr, 20, 50)

#     strokeWeight(4)
#     stroke(204, 102, 0)
#     fill(0, 255, 0)
#     rect(20, height - 100, 150, 50)  # Green button
#     textSize(32)
#     fill(0, 0, 255)
#     text("Click on textbox to type something:", 20, height - 150)

#     # Draw the button(s)
#     if button == 1:
#         equation.updateEquation(myText)
#         button = 0  # Reset the button state

#     for slider in sliders:
#         slider.draw()

#     graph.drawScale(50, 1.0, graph.width / 2 + 300, graph.height / 2)
#     graph.plotStandardForm(equation.a, equation.b, equation.c)

# def mouseClicked():
#     global equation, sliders, graph, myText
#     if 20 <= mouseX <= 170 and height - 100 <= mouseY <= height - 50:
#         myText = ""  # Clear the text when the button is clicked
#     for slider in sliders:
#         slider.mouseClicked()
#         # Update the equation object with the new slider values
#         equation.a = sliders[0].adjustment2
#         equation.b = sliders[1].adjustment2
#         equation.c = sliders[2].adjustment2

# def mouseDragged():
#     global equation, sliders, graph
#     for slider in sliders:
#         slider.mouseDragged()
#         # Update the equation object with the new slider values
#         equation.a = sliders[0].adjustment2
#         equation.b = sliders[1].adjustment2
#         equation.c = sliders[2].adjustment2
#     graph.plotStandardForm(equation.a, equation.b, equation.c)
    
# def keyPressed():
#     global myText, button
#     if 20 <= mouseX <= 170 and height - 100 <= mouseY <= height - 50:
#         if key == BACKSPACE:
#             myText = myText[:-1]
#         elif key.isalnum() or key in ["^", "+", "-", "*", "/"]:
#             myText += key
#         elif key == ENTER:
#             button = 1


#==============================================================================


# def setup():
#   global prompt, myText, wasMyText, start, reverseName, button
#   # initialize global variables
#   prompt = "Click on textbox to type something:"
#   myText = ''
#   wasMyText = ''
#   start = True
#   button = 0
#   size(600, 600)
#   textAlign(LEFT, TOP)
#   textSize(15)
#   fill(0)

# # note the various forms of the text() function below - see processing.org
# def draw(): 
#   global prompt, myText, wasMyText, start, button
  
#   background(255)

#   # draw button(s)
#   strokeWeight(4)
#   stroke(204, 102, 0)
#   fill(0, 255, 0)
#   rect(100, 100, 150, 50) # green button
#   textSize(32)
#   fill(0, 0, 255)
#   text(prompt, 10, 10)
 
#   if button == 1:
#       text(myText, 100, 100)

#   text(wasMyText, 300, 100)


     
# # the keyPressed() function is called (runs) whenever a key is pressed
# def keyPressed():
#   global prompt, myText, wasMyText, start, button
  
#   #print(key, keyCode, type(key), type(keyCode), button)

#   #remove the > prompt when typing starts
#   if start:
#     myText = ""
#     start = False
  
#   # note built-in variable 'keyCode' (int)
#   # note various ASCII codes (in decimal) for backspace (8), delete (127), enter (10) etc.
  
#   if keyCode == 8 and len(myText) > 0: # BACKSPACE if char is there
#     myText = myText[0: len(myText)-1]
#   elif keyCode == 8:                   # nothing to BACKSPACE over so do nothing
#     pass
#   elif keyCode == 16:                  # SHIFT key - do nothing
#     pass
#   elif keyCode == 127:                 # start over again with prompt on DELETE
#     myText = ">"
#     start = True
#   elif keyCode == 10:                  # capture text and start over again with prompt on ENTER
#     wasMyText = myText
#     myText = ""
#     start = True
#   else:                                # add char to string
#     myText = myText + str(key)

# def mouseClicked():
#     global button, myText
#     if mouseX >= 100 and mouseX <= 250 and mouseY >= 100 and mouseY <= 150:
#         button = 1
#         start = True
#         myText = ''
#     else:
#         button = 0




#===============================================================================


# def background_gradient(c1, c2, w, h):
#     for i in range(h):
#         inter = lerpColor(c1, c2, float(i) / h)
#         stroke(inter)
#         line(0, i, w, i) 

#     myFont = createFont("Verdana", 25)
#     textFont(myFont)
    
# def first():
#     fill(0)
#     # Heading text
#     textSize(32)
#     headingTextWidth = textWidth("Graph Observer")
#     text("Graph Observer", width/2 - headingTextWidth/2, height/3)
#     # global prompt, myText, wasMyText, start, reverseName, button
#     prompt = "Click on textbox to type something:"
#     myText = ''
#     wasMyText = ''
#     start = True
#     button = 0
#     textAlign(LEFT, TOP)
#     textSize(15)
#     fill(0)

#     # Text box
#     textSize(16)
#     textBoxWidth = 200
#     textBoxHeight = 30
#     textBoxX = width/2 - textBoxWidth/2
#     textBoxY = height/2 - textBoxHeight/2

#     rect(textBoxX, textBoxY, textBoxWidth, textBoxHeight)
#     fill(255)
#     text("Type here", width/2, height/2)


# def second():
#     textSize(32)
#     fill(0, 255, 0)
#     text("two", width/2 - 50, height/2 - 16)
#     circle(width/2 - 50, 100, 100)

# def third():
#     textSize(32)
#     fill(0, 0, 255)
#     text("three", width/2 - 50, height/2 - 16)
#     triangle(500, 100, 550, 200, 500, 300)
    
        
# def main():
#     global state, button
#   # draw button(s)
#     fill(255, 255, 0)
#     rect(100, 500, 50, 50) # start button
#     textSize(32)
#     fill(255, 0, 0)
#     text("main", width/2 - 50, height/2 - 16)
#     fill(0, 0, 0)
#     text("start", 100, 450)

#   # service button(s)
#     if button == 1:
#         state = 1  # start in solid state
#         button = 0 # reset button back to 0 serviced


# # state 1 - solid
# def solid():
#     global state, button

#   # draw button(s)
#     fill(0, 255, 255)
#     rect(200, 500, 50, 50) # stop button
#     fill(0, 0, 255)
#     rect(300, 500, 50, 50) # cold button
#     fill(255, 255, 0)
#     rect(400, 500, 50, 50) # hot button
#     fill(255, 0, 0)
#     rect(500, 500, 50, 50) # hotter button
#     textSize(32)
#     fill(0, 0, 255)
#     text("solid", width/2 - 50, height/2 - 16)
#     fill(0, 0, 0)
#     text("stop", 200, 450)
#     text("cold", 300, 450)
#     text("hot", 400, 450)
#     text("hotter", 500, 450)
    
#   # service button(s)
#     if button == 2:
#         state = 0     # back to main menu
#         button = 0
#     elif button == 4:
#         state = 2     # liquid state
#         button = 0
#     elif button == 5:
#         state = 3     # gas state
#         button = 0
#     else:
#         pass

# # state 2 - liquid
# def liquid():
#     global state, button

#     # draw button(s)
#     fill(0, 0, 255)
#     rect(300, 500, 50, 50) # cold button
#     fill(255, 0, 0)
#     rect(400, 500, 50, 50) # hot button
#     textSize(32)
#     fill(0, 255, 0)
#     text("liquid", width/2 - 50, height/2 - 16)
#     fill(0, 0, 0)
#     text("cold", 300, 450)
#     text("hot", 400, 450)
    
#   # service button(s)
#     if button == 3:
#         state = 1      # solid state
#         button = 0
#     elif button == 4:
#         state = 3      # gas state
#         button = 0
#     else:
#         pass

# # state 3 - gas
# def gas():
#     global state, button

#     # draw button(s)
#     fill(0, 0, 255)
#     rect(300, 500, 50, 50) # colder button
#     fill(0, 255, 0)
#     rect(400, 500, 50, 50) # cold button
#     fill(255, 0, 0)
#     rect(500, 500, 50, 50) # hot button
#     textSize(32)
#     fill(255, 0, 0)
#     text("gas", width/2 - 50, height/2 - 16)
#     fill(0, 0, 0)
#     text("colder", 275, 450)
#     text("cold", 400, 450)
#     text("hot", 500, 450)

#     # service button(s)
#     if button == 4:
#         state = 2     # liquid state
#         button = 0
#     elif button == 3:
#         state = 1     # solid state
#         button = 0
#     else:
#         pass

# def setup():
#     global step, state, button
#     # global prompt, myText, wasMyText, start, reverseName, button
#     size(600, 600)
#     noStroke()
#     step = 0
#     state = 0
#     button = 0 

# def draw():
#     global step, state, button
#     background_gradient(color(0, 0, 255), color(255, 255, 255), width, height)

#     # fill(255, 0, 0)
#     # rect(100, 500, 50, 50)
#     # fill(0, 0, 255)
#     # rect(500, 500, 50, 50)
 
#     if step == 0:
#         first()
#     elif step == 1:
#         second()
#     else:
#         third()
        
#     # if state == 0:
#     #     main()
#     # elif state == 1:
#     #     solid()
#     # elif state == 2:
#     #     liquid()
#     # elif state == 3:
#     #     gas()
#     # else:
#     #     pass

# def keyPressed():
#     global step
#     if key == 65535:
#         if keyCode == 37 or keyCode == 40:
#             step = step - 1
#             if step < 0:
#                 step = 0
#         elif keyCode == 38 or keyCode == 39:
#             step = step + 1
#             if step > 2:
#                 step = 2
#         else:
#             pass

# def mouseClicked():
#     global step, button
#     if mouseX >= 100 and mouseX <= 150 and mouseY >= 500 and mouseY <= 550:
#         button = 1
#     if mouseX >= 200 and mouseX <= 250 and mouseY >= 500 and mouseY <= 550:
#         button = 2
#     elif mouseX >= 300 and mouseX <= 350 and mouseY >= 500 and mouseY <= 550:
#         button = 3
#     elif mouseX >= 400 and mouseX <= 450 and mouseY >= 500 and mouseY <= 550:
#         button = 4
#     elif mouseX >= 500 and mouseX <= 550 and mouseY >= 500 and mouseY <= 550:
#         button = 5
#     # if mouseX >= 100 and mouseX <= 150 and mouseY >= 500 and mouseY <= 550:
#     #     step = step - 1
#     #     if step < 0:
#     #         step = 0
#     # elif mouseX >= 500 and mouseX <= 550 and mouseY >= 500 and mouseY <= 550:
#     #     step = step + 1
#     #     if step > 2:
#     #         step = 2
#     else:
#         pass

# def background_gradient(c1, c2, w, h):
#     for i in range(h):
#         inter = lerpColor(c1, c2, float(i) / h)
#         stroke(inter)
#         line(0, i, w, i)

#     myFont = createFont("Verdana", 25)
#     textFont(myFont)

# def setup():
#     global prompt, myText, wasMyText, start, inputBoxClicked
#     size(600, 600)
#     noStroke()
#     # textAlign(CENTER, CENTER)
#     fill(255, 0, 0)
#     prompt = ">Enter a quadratic equation in standared form: ax^2+bx+c"
#     myText = ""
#     wasMyText = ""
#     start = True
#     inputBoxClicked = False

# def draw():
#     global prompt, myText, wasMyText, start, inputBoxClicked

#     background(255)
#     background_gradient(color(0, 0, 255), color(255, 255, 255), width, height)

#     # Draw heading text
#     headingText = "Graph Observer"
#     headingTextWidth = textWidth(headingText)
#     textAlign(CENTER, CENTER)
#     fill(0)
#     textSize(45)
#     text(headingText, width / 2, height / 3)

#     # Draw rectangle and handle input box interaction
#     stroke(0)
#     fill(0, 255, 0)
#     rect(width / 2 - 150, height / 2 - 20, 300, 40, 10, 10, 10, 10)

#     if inputBoxClicked:
#         textAlign(TOP, LEFT)
#         fill(0)
#         textSize(20)
#         # text(myText, width / 2, height / 2)
#         text(myText, width / 2 - 160 + 18, height / 2 + (20 / 2) - 3)
#         # rect(width / 2 - 150, height / 2 - 17.5, 300, 35, 10, 10, 10, 10)
#     else:
#         textAlign(CENTER, CENTER)
#         fill(255, 0, 0)
#         textSize(15)
#         text(prompt, width / 2, (height / 2) + 50)

# def mouseClicked():
#     global myText, inputBoxClicked

#     if (
#         mouseX >= width / 2 - 150
#         and mouseX <= width / 2 + 150
#         and mouseY >= height / 2 - 17.5
#         and mouseY <= height / 2 + 17.5
#     ):
#         # strokeWeight(2)
#         inputBoxClicked = True
#         myText = ""
#     else:
#         # strokeWeight(0)
#         inputBoxClicked = False

# def keyPressed():
#     charsAllowed = "0123456789xX^+-()/"
#     global myText, start

#     # Remove the '>' prompt when typing starts
#     if start:
#         myText = ""
#         start = False

#     # Note various ASCII codes (in decimal) for backspace (8), delete (127), enter (10) etc.
#     if keyCode == 8 and len(myText) > 0:  # BACKSPACE if char is there
#         myText = myText[0: len(myText) - 1]
#     # elif keyCode == 8 and myText = "":  # Nothing to BACKSPACE over so do nothing
#     #     pass
#     elif keyCode == 16:  # SHIFT key - do nothing
#         pass
#     elif keyCode == 127:  # Start over again with prompt on DELETE
#         myText = ">"
#         start = True
#     elif keyCode == 10:  # Capture text and start over again with prompt on ENTER
#         entredEquation = myText
#         myText = ""
#         start = True
#     elif key in charsAllowed:
#         myText += key
#     elif keyCode == SHIFT:  # Shift key pressed
#         shiftKeyHeld = True

# def keyReleased():
#     global shiftKeyHeld
#     if keyCode == SHIFT:  # Shift key released
#         shiftKeyHeld = False
