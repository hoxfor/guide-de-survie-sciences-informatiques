class SMSStore:
    def __init__(self):
        self.sms_list = []
        
    def add_new_arrival(self, from_number, time_arrived, text_of_SMS):
        has_been_viewed = False
        self.sms_list.append((has_been_viewed, from_number, time_arrived, text_of_SMS))
        
    def message_count(self):
        return len(self.sms_list)
    
    def get_unread_indexes(self):
        unread_msg = []
        for index, tuple_msg in enumerate(self.sms_list):
            if tuple_msg[1] == False:
                unread_msg.append(index)
        return unread_msg
    
    def get_message(self, index):
        index -= 1
        try:
            self.sms_list[index] = (True, self.sms_list[index][1], self.sms_list[index][2], self.sms_list[index][3])
            return (self.sms_list[index][1], self.sms_list[index][2], self.sms_list[index][3])
        except IndexError:
            return None
        
    def delete(self, index):
        index -= 1
        try:
            del self.sms_list[index]
        except IndexError:
            pass
        
    def clear(self):
        self.sms_list = []