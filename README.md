# json-data-mapper
JsonPath Data Mapper

### input

```json
{
	"SortAs": "SGML",
	"GlossTerm": "Standard Generalized Markup Language",
	"Acronym": "SGML",
	"Abbrev": "ISO 8879:1986"
}
```
### Mapper

```json
{
  	"SortAs": "SortAs",
	"GlossTerm": "GlossTerm",
	"NewAcronym": "Acronym",
	"Abbrev": "Abbrev",
	"Abbrev2": "Abbrev"
}
```

### Result

```json
{
  "GlossTerm":"Standard Generalized Markup Language",
  "SortAs":"SGML",
  "NewAcronym":"SGML",
  "Abbrev2":"ISO 8879:1986",
  "Abbrev":"ISO 8879:1986"
}
``
