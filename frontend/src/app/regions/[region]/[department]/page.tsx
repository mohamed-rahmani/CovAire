type PageParams = Promise<{ region: string; department: string }>;

export default async function page({ params }: { params: PageParams }) {
  const { region, department } = await params;
  return (
    <div className="bg-white w-full rounded-2xl border border-gray-300 shadow-md mb-7">
      <div className="px-6 py-6 text-[#898989]">
        {decodeURIComponent(region)} {">"} {decodeURIComponent(department)}
      </div>
      <div className="grid grid-cols-3 gap-5 px-6"></div>
    </div>
  );
}
