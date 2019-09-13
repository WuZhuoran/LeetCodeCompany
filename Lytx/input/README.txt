README
We would like to use this dataset to get a better understanding of how you think about data your approach to solving new problems. Please examine it and try to come up with some insights. We would then like you to prepare a 20 minute presentation that describes your analysis approach and highlights any insights you may have found. We are more interested in your approach, so feel free to also include ideas you may have that you did not have time to fully explore.

NOTE 1: Please do not feel you need to spend too much time with it. No more than two days should be spent analyzing and preparing the slides.

For questions or issues with the data, please contact Stephen Krotosky (skrotosky@lytx.com) or Jesse Daniels (jesse.daniels@lytx.com) 


DESCRIPTION
This dataset summarizes driver behavior over a six-month time period. The goal is to develop insights from this dataset to help identify risky drivers and better understand correlative factors related to collisions.

NOTE 2: Predicting collisions is inherently difficult. We do not expect performance at levels common to other curated or demonstration datasets, such as UC-Irvine, etc.


DATASET INFORMATION:
- Each row is a driver's six-month driving history. 
    - For drivers who were in a collision, the 6 month window ends the day before their collision. If a driver had multiple collisions, each incident would have a separate row.
    - For non-collision drivers, the 6 month window is taken randomly over the year that was considered for the dataset
    - Each feature indicates the occurrence of a behavior or trigger. The cause of these triggers/behaviors have been anonymized. The total count of behaviors is not included, nor is the distance/time of driving.
    - Non-collision drivers are down-sampled to reduce class skew.
    
COLUMN DESCRIPTION
- Output Variable:
Column 1)  label: binary variable indicating whether the driver was involved in a collision or not

- Input Variables
Column 2) driver_id: a unique identifier for each driver
Column 3) event_dt: date variable indicating the date of the collision event or randomly selected date for non-collision driver
Column 4) industry: categorical variable indicating the driver's industry type
Columns 5-18): binary indicator variables indicating whether a particular trigger was seen for this driver
Columns 19-70): binary indicator variables indicating whether a particular behavior was seen for this driver

    