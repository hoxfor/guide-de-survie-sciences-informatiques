class EmployeeDidntWorked(Exception):
    pass

class EmployeeWorkedNegatively(Exception):
    pass

class EmployeeWorkedTooMuch(Exception):
    pass

class PayIsNegative(Exception):
    pass

class PayIsTooBig(Exception):
    pass

def pay_employee(employee, hours_worked):
    if hours_worked == 0:
        raise EmployeeDidntWorked
    elif hours_worked < 0:
        raise EmployeeWorkedNegatively
    elif hours_worked > 744:
        raise EmployeeWorkedTooMuch
    elif employee.pay < 0:
        raise PayIsNegative
    elif employee.pay > 100:
        raise PayIsTooBig
    employee.receive_salary(hours_worked*employee.pay)