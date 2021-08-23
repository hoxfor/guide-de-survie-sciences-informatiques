class Command:
    
    __total_price = 0
    __total_commands = 0
    
    @classmethod
    def get_number_total_command(cls):
        return cls.__total_commands
    
    @classmethod
    def set_new_total_price(cls, price):
        cls.__total_price += price
    
    @classmethod
    def get_total_price(cls):
        return cls.__total_price
    
    @classmethod
    def new_command(cls):
        cls.__total_commands += 1
    
    def __init__(self, id_buyer, id_item, quantity_item, price_item):
        self.id_buyer = id_buyer
        self.id_item = id_item
        self.quantity = quantity_item
        self.price = price_item
        Command.set_new_total_price(price_item*quantity_item)
        Command.new_command()
        
    def __str__(self):
        return "{}, {} : {} * {} = {}".format(
            self.id_buyer, self.id_item, self.price, self.quantity, self.price*self.quantity
            )