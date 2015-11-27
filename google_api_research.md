Google Places API Web Service Research
=============================

* hint: to view JSON files in Google Chrome install JSONView

## API key
* get it here: https://developers.google.com/places/web-service/get-api-key
* my key: `AIzaSyDA4Hnvwl4uL6ci6qm7Z0LeyVGPjTA0AC0`
    
## Place Search types and their parameters comparison 
* all here: https://developers.google.com/places/web-service/search

### Nearby Search

  Searches for a place in a given radius of some location based on name, keyword and types.

  * `key`
  * `location (latitude=X,longitude=Y)`
  * `radius`
  * `ranby=distance (default: rankby=prominence)`
  * `keyword`
  * `name`
  * `types=type1|type2|type3`

  example: https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=50.069680,19.906700&radius=500&types=gym&key=AIzaSyDA4Hnvwl4uL6ci6qm7Z0LeyVGPjTA0AC0

### Text Search

  Searches for a place in a given radius of some location based on query (like "italian pizza in new york"), name, keyword and types. 
  CAUTION: every Text Search request counts as 10 regular requests!!!

  * `query`
  * `key`
  * `location (latitude=X,longitude=Y)`
  * `radius`
  * `ranby=distance (default: rankby=prominence)`
  * `keyword`
  * `name`
  * `types=type1|type2|type3`

  example: https://maps.googleapis.com/maps/api/place/textsearch/json?query=crossfit+in+Kraków&key=AIzaSyDA4Hnvwl4uL6ci6qm7Z0LeyVGPjTA0AC0

### Radar Search

  Similar to Nearby Search but different in that it quickly produces many more results in exchange for being less precise and returning less info about places - just "scans" the area.
  * `key`
  * `location (latitude=X,longitude=Y)`
  * `radius`
  * `keyword`
  * `name`
  * `types=type1|type2|type3`

## Place Details:

  example: https://maps.googleapis.com/maps/api/place/details/json?placeid=ChIJX8YOUKNbFkcRbvWUWZQgwqo&key=AIzaSyDA4Hnvwl4uL6ci6qm7Z0LeyVGPjTA0AC0

## Place Photos:

  example: https://maps.googleapis.com/maps/api/place/photo?maxwidth=800&photoreference=CmRdAAAAwheOZV5GqkBnsycEEMLIN9Dtbzu8Fh5mSv7Ac5-Q_OT8gNpPDV_RunFr11eVlV-MBpJsKr2lOEpvub0b5WJUDNgCxJmCWcacCEoZ71XqnebRwftxM-TQL3Y6VRapvRyDEhB6Om3Z_sLvCqyyhnQ7YNXpGhSengps_eDbdNMX3mvF-oywBItbfw&key=AIzaSyDA4Hnvwl4uL6ci6qm7Z0LeyVGPjTA0AC0

## Place Autocomplete:

  example: https://maps.googleapis.com/maps/api/place/autocomplete/json?input=krak&types=geocode&key=AIzaSyDA4Hnvwl4uL6ci6qm7Z0LeyVGPjTA0AC0

## API request limitations

  1. without verification - free 1000 rqs / 24 hrs
  2. after verification (billing needs to be enabled which requires providing credit card data) - free 150 000 rqs / 24 hrs
  3. with Google Maps API for Work license - more 

## Terms of use

  A whole bunch of "does" and "don'ts" e.g. you can't store data retrieved from the API, only place ids. 

  * https://developers.google.com/places/web-service/policies#terms_of_use
  * https://developers.google.com/maps/terms

## Available relevant search tags:

  * gym
  * stadium
  * spa
  * physiotherapist

Too few - must rely on keyword/name parameters

## Output types:

  * `json` - recommended
  * `xml`

## Future project extensions:

  * Query Autocomplete - https://developers.google.com/places/web-service/query
  * user account storing user's places (in form of place ids)
  * multiple languages support


