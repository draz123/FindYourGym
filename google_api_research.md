Google Places API Web Service Research
=============================

* hint: to view JSON files in Google Chrome install JSONView
* hint: parsing JSON with JS: [link][JS]

[JS]: https://developers.google.com/maps/web-services/overview#ParsingJSON

## API key

* get it here: https://developers.google.com/places/web-service/get-api-key
* my key: `AIzaSyDA4Hnvwl4uL6ci6qm7Z0LeyVGPjTA0AC0`
    
## Place Search types and their parameters comparison

* all here: https://developers.google.com/places/web-service/search

### Nearby Search

Searches for a place in a given radius of some location based on name, keyword and types.

#### request parameters

  * `key`
  * `location (latitude=X,longitude=Y)`
  * `radius`
  * `ranby=distance (default: rankby=prominence)`
  * `keyword`
  * `name`
  * `types=type1|type2|type3`

#### example request

https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=50.069680,19.906700&radius=500&types=gym&key=AIzaSyDA4Hnvwl4uL6ci6qm7Z0LeyVGPjTA0AC0

### Text Search

Searches for a place in a given radius of some location based on query (like "italian pizza in new york"), name, keyword and types. 
CAUTION: every Text Search request counts as 10 regular requests!!!

#### request parameters

  * `query`
  * `key`
  * `location (latitude=X,longitude=Y)`
  * `radius`
  * `ranby=distance (default: rankby=prominence)`
  * `keyword`
  * `name`
  * `types=type1|type2|type3`

#### example requests

https://maps.googleapis.com/maps/api/place/textsearch/json?query=crossfit+in+Krakow&key=AIzaSyDA4Hnvwl4uL6ci6qm7Z0LeyVGPjTA0AC0

### Radar Search

Similar to Nearby Search but different in that it quickly produces many more results in exchange for being less precise and returning less info about places - just "scans" the area.

#### request parameters

  * `key`
  * `location (latitude=X,longitude=Y)`
  * `radius`
  * `keyword`
  * `name`
  * `types=type1|type2|type3`

#### example requests

https://maps.googleapis.com/maps/api/place/radarsearch/json?location=50.069680,19.906700&radius=500&types=gym&key=AIzaSyDA4Hnvwl4uL6ci6qm7Z0LeyVGPjTA0AC0

## Place Details

#### example requests

https://maps.googleapis.com/maps/api/place/details/json?placeid=ChIJX8YOUKNbFkcRbvWUWZQgwqo&key=AIzaSyDA4Hnvwl4uL6ci6qm7Z0LeyVGPjTA0AC0

## Place Photos

#### example requests

https://maps.googleapis.com/maps/api/place/photo?maxwidth=800&photoreference=CmRdAAAAwheOZV5GqkBnsycEEMLIN9Dtbzu8Fh5mSv7Ac5-Q_OT8gNpPDV_RunFr11eVlV-MBpJsKr2lOEpvub0b5WJUDNgCxJmCWcacCEoZ71XqnebRwftxM-TQL3Y6VRapvRyDEhB6Om3Z_sLvCqyyhnQ7YNXpGhSengps_eDbdNMX3mvF-oywBItbfw&key=AIzaSyDA4Hnvwl4uL6ci6qm7Z0LeyVGPjTA0AC0

## Place Autocomplete

#### example requests

https://maps.googleapis.com/maps/api/place/autocomplete/json?input=krak&types=geocode&key=AIzaSyDA4Hnvwl4uL6ci6qm7Z0LeyVGPjTA0AC0

## Response structure

### example response

```json
{
   "html_attributions" : [],
   "results" : [
      {
         "geometry" : {
            "location" : {
               "lat" : 50.0720795,
               "lng" : 19.9028782
            }
         },
         "icon" : "https://maps.gstatic.com/mapfiles/place_api/icons/generic_business-71.png",
         "id" : "2aaa4fc59bc4fab6015e85076508793b2e5f8f83",
         "name" : "Fitness Siłownia Odchudzenie Kraków",
         "photos" : [
            {
               "height" : 413,
               "html_attributions" : [
                  "\u003ca href=\"https://maps.google.com/maps/contrib/113473091761924809057\"\u003eFitness Siłownia Odchudzenie Kraków\u003c/a\u003e"
               ],
               "photo_reference" : "CmRdAAAAVwp8MmEal6XXBVLe3sHf6eKEXivdPJNTBrozsMufouVPHsiApeoFqvVoN9Ta9ONkRa0MzLXuldyCprvusKI5OeC_swX594jCtv8htwG_XRTBhMBQbhrwwjvzeWZYEfQMEhAqupHBMNDehxnFK8xuKuJzGhRNRPNdz6Eawte0EVJ6JrwPiq2NzQ",
               "width" : 400
            }
         ],
         "place_id" : "ChIJY08txrlbFkcRfCGxOGLLPLk",
         "reference" : "CoQBeQAAAOdCC7QUJ0mb6nPhmqZfAMpFX7LoTAbbPcLwlVLCncl3XvVK1Y3rODiv8r4CamibYW7_0Lp7mWszIqjxV01A2qVzsgNQKUo7jfL4Xu7KX9RcCLhF9KE5dfdt8PsUFKsBOafHxCltNRpMhz15ZCrT570kX0Q2hFr5ZuMqiTu4hzrmEhAIgLfpqNzZUfBf3Vjx4crwGhT1aWNpJELFfJeeTh9baiy3aTHBWQ",
         "scope" : "GOOGLE",
         "types" : [ "gym", "health", "point_of_interest", "establishment" ],
         "vicinity" : "Juliusza Lea 114, Kraków"
      }
   ],
   "status" : "OK"
}
``` 

### response elements 

  * `"status"` contains metadata on the request
  * `"results"` contains an array of places, with information about each
  * `"html_attributions"` contain a set of attributions about this listing which must be displayed to the user (rules of use)
  * `"next_page_token"` contains a token that can be used to return up to 20 additional results

## API request limitations

  1. without verification - free 1000 rqs / 24 hrs
  2. after verification (billing needs to be enabled which requires providing credit card data) - free 150 000 rqs / 24 hrs
  3. with Google Maps API for Work license - more 

## Terms of use

  A whole bunch of "does" and "don'ts" e.g. you can't store data retrieved from the API, only `place_id`s. 

  * https://developers.google.com/places/web-service/policies#terms_of_use
  * https://developers.google.com/maps/terms

## Available relevant search tags

  * `gym`
  * `stadium`
  * `spa`
  * `physiotherapist`

Too few - must rely on `keyword`/`name` parameters

## Response formats

  * `json` - recommended
  * `xml`

## Future project extensions:

  * Query Autocomplete - https://developers.google.com/places/web-service/query
  * user account storing user's places (in form of `place_id`s)
  * multiple languages support

## Conclusion

  * For this project we only need using the API without verification (1000 reqs / 24 hrs)
  * Nearby Search suits us best - Text Search is quite complex and Radar Search is for quickly finding "anything", not detailed info about the places we need
  * We don't need Place Autocomplete in the beginning
  * Data we can get from the API:
    * name
    * vicinity (address)
    * phone number
    * opening hours
    * photos
    * rating (TODO: check how it's calculated)
    * reviews
    * website
    * THEORETICALLY: price (in reality, price_level field is usually blank)
  * Data we lack:
    * equipment
    * price
    * opening hours e.g. for Krav Maga classes:
      https://maps.googleapis.com/maps/api/place/details/json?placeid=ChIJ95j6CwxbFkcRdl24J0UdEIs&key=AIzaSyDA4Hnvwl4uL6ci6qm7Z0LeyVGPjTA0AC0