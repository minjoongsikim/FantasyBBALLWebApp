from basketball_reference_web_scraper import client
from basketball_reference_web_scraper.data import OutputType

# Change as needed to generate correct JSON Files
CurrentYear = 2021;

# Get all player season totals for the 2017-2018 season and output in JSON format
print("Getting player season totals for " + str(CurrentYear - 1) + "-" + str(CurrentYear) + "season in JSON format")
print(client.players_season_totals(season_end_year=CurrentYear, output_type=OutputType.JSON,
                                   output_file_path="Files/current_season_stats.json"))
