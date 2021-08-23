parameters = command.split ()
try:
    if parameters[0] == "divide":
        print ( "The value of your division is: {0}".format ( float(parameters[1])/float(parameters[2])))
    elif parameters[0] == "showfile":
        file = open ( parameters[1] )
        print ( file.read () )
        file.close ()
except:
    print ( "There was an error")