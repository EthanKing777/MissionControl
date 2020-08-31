import rocketpy
import datetime

Env = rocketpy.Environment(
    railLength=5,
    latitude=-41.1341297,
    longitude=175.0276063,
    elevation=876
)
tomorrow = datetime.date.today() + datetime.timedelta(days=1)
Env.setDate((tomorrow.year, tomorrow.month, tomorrow.day, 00))  # noon is 0UTC
Env.setAtmosphericModel(type='Forecast', file='GFS')
Env.info()

# Env.windSpeed(1000)  #windspeed at 1000m
# Env.windDirection(1000)  #wind direction at 1000m
# #also windVelocityX and windVelocityY for X and Y components of wind
# Env.temperature(1000) #in  kelvin
# Env.pressure(1000) # pressure Pa
