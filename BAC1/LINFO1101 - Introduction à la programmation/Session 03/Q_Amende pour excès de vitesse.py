def fine(authorized_speed, actual_speed):
    if actual_speed > authorized_speed and actual_speed < (authorized_speed + 3):
        return 12.5
    elif actual_speed >= (authorized_speed + 3) and actual_speed < (authorized_speed + 10):
        return (actual_speed - authorized_speed)*5
    elif actual_speed >= (authorized_speed + 10):
        return ((actual_speed - authorized_speed)*5)*2
    else:
        return 0