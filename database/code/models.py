from peewee import *
database = MySQLDatabase('jedi_academy', **{'charset': 'utf8', 'sql_mode': 'PIPES_AS_CONCAT', 'use_unicode': True, 'user': 'root'})

class UnknownField(object):
    def __init__(self, *_, **__): pass

class BaseModel(Model):
    class Meta:
        database = database

class Instructors(BaseModel):
    email = CharField()
    first_name = CharField()
    last_name = CharField()
    phone = CharField(null=True)

    class Meta:
        table_name = 'instructors'

class Batches(BaseModel):
    description = CharField(null=True)
    instructor = ForeignKeyField(column_name='instructor_id', field='id', model=Instructors, null=True)
    name = CharField()
    start_date = DateField()

    class Meta:
        table_name = 'batches'

class Students(BaseModel):
    address = CharField(null=True)
    batch = ForeignKeyField(column_name='batch_id', field='id', model=Batches, null=True)
    birth_date = DateField(null=True)
    email = CharField()
    first_name = CharField()
    iq = IntegerField(null=True)
    last_name = CharField()
    phone = CharField(null=True)

    class Meta:
        table_name = 'students'
