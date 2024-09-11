/**
 * Purpose: process the table before exporting to a XLS file
 * Based on version: 11.2.0.0
 */
zk.afterLoad('chart', function() {
    Highcharts.wrap(Highcharts.Chart.prototype, 'getTable', function(originalFunction, useLocalDecimalPoint) {
        let table = originalFunction();
        console.log(table);//process the table
    });
});