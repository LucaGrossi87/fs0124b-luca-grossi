--SELECT * FROM "epicode_m4s3g1_ex".clienti
--SELECT * FROM "epicode_m4s3g1_ex".fornitori
--SELECT * FROM "epicode_m4s3g1_ex".prodotti
--SELECT * FROM "epicode_m4s3g1_ex".fatture

--select * from "epicode_m4s3g1_ex".clienti cl where cl.nome = 'Mario'

--select nome, cognome from "epicode_m4s3g1_ex".clienti cl where cl."Anno di Nascita" = '1982' 

--select numeroFattura from "epicode_m4s3g1_ex".fatture fat where fat.iva='20'

--select * from "epicode_m4s3g1_ex".prodotti prod where extract(year from prod.dataAttivazione)='2017' and (prod.inproduzione = 'true' or prod.incommercio = 'true')

--select * from "epicode_m4s3g1_ex".fatture fat join "epicode_m4s3g1_ex".clienti cl on fat.numerocliente = cl.numerocliente where fat.importo < '1000'

--select fat.numerofattura, fat.importo, fat.iva, fat.datafattura, forn.denominazione from "epicode_m4s3g1_ex".fatture fat join "epicode_m4s3g1_ex".fornitori forn on fat.numerofornitore = forn.numerofornitore

--select iva, extract(year from fat.datafattura), count (*) from "epicode_m4s3g1_ex".fatture fat where fat.iva='20' group by fat.iva, extract(year from fat.datafattura)

--select sum(importo) as totale ,extract(year from fat.datafattura) , count(*) from "epicode_m4s3g1_ex".fatture fat group by extract(year from fat.datafattura)

--select extract(year from fat.datafattura), count (*) from "epicode_m4s3g1_ex".fatture fat where fat.tipologia='Servizi di consulenza' group by extract(year from fat.datafattura) having count(*)>2

--select distinct cl.regioneresidenza, sum(fat.importo) as totale from "epicode_m4s3g1_ex".fatture fat join "epicode_m4s3g1_ex".clienti cl on fat.numerocliente = cl.numerocliente group by cl.regioneresidenza

--select cl."Anno di Nascita", count (*) from "epicode_m4s3g1_ex".clienti cl join "epicode_m4s3g1_ex".fatture fat on cl.numerocliente = fat.numerocliente where cl."Anno di Nascita" = '1980' and fat.importo > 50 group by cl."Anno di Nascita"