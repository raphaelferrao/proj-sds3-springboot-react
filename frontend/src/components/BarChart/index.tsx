import { useEffect, useState } from "react";

import axios from "axios";
import Chart from "react-apexcharts";

import { round } from "utils/format";
import { BASE_URL } from "utils/requests";
import { SaleSuccess } from "types/sale";

type LabelsData = {
  categories: string[];
};

type SeriesData = {
  name: string;
  data: number[];
};

type ChartData = {
  labels: LabelsData;
  series: SeriesData[];
};

const BarChart = () => {
  const [chartData, setChartData] = useState<ChartData>({
    labels: { categories: [] },
    series: [],
  });

  useEffect(() => {
    axios.get(`${BASE_URL}/sales/success-by-seller`).then((response) => {
      const data = response.data as SaleSuccess[];
      const myLabels = data.map((x) => x.sellerName);
      const mySeries = data.map((x) => round((100.0 * x.deals) / x.visited, 1));

      setChartData({
        labels: { categories: myLabels },
        series: [{ name: "% Sucesso", data: mySeries }],
      });
    });
  }, []);

  const options = {
    plotOptions: {
      bar: {
        horizontal: true,
      },
    },
  };

  return (
    <Chart
      options={{ ...options, xaxis: chartData.labels }}
      series={chartData.series}
      type="bar"
      height="240"
    />
  );
};

export default BarChart;
