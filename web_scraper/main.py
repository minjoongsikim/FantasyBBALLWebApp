from basketball_reference_web_scraper import client
from basketball_reference_web_scraper.data import OutputType

# Get all player season totals for the 2017-2018 season and output in JSON format
print("Getting player season totals for 2020-2021 season in JSON format")
print(client.players_season_totals(season_end_year=2021, output_type=OutputType.JSON))
